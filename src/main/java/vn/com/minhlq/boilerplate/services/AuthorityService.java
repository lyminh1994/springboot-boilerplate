package vn.com.minhlq.boilerplate.services;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import vn.com.minhlq.boilerplate.constant.Consts;
import vn.com.minhlq.boilerplate.constant.Status;
import vn.com.minhlq.boilerplate.dto.UserPrincipal;
import vn.com.minhlq.boilerplate.exception.SecurityException;
import vn.com.minhlq.boilerplate.model.Permission;
import vn.com.minhlq.boilerplate.model.Role;
import vn.com.minhlq.boilerplate.repositories.PermissionRepository;
import vn.com.minhlq.boilerplate.repositories.RoleRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class AuthorityService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RequestMappingHandlerMapping mapping;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        checkRequest(request);

        Object userInfo = authentication.getPrincipal();
        boolean hasPermission = false;

        if (userInfo instanceof UserDetails) {
            UserPrincipal principal = (UserPrincipal) userInfo;
            Long userId = principal.getId();

            List<Role> roles = roleRepository.selectByUserId(userId);
            List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
            List<Permission> permissions = permissionRepository.selectByRoleIdList(roleIds);

            // Get resources, separate front and back ends, so filter page permissions, only keep button permissions
            List<Permission> btnPermissions = permissions.stream()
                    // Filter page permissions
                    .filter(permission -> Objects.equals(permission.getType(), Consts.BUTTON))
                    // Filter URL is empty
                    .filter(permission -> StringUtils.isNotBlank(permission.getUrl()))
                    // Filter METHOD is empty
                    .filter(permission -> StringUtils.isNotBlank(permission.getMethod()))
                    .collect(Collectors.toList());

            for (Permission btnPermission : btnPermissions) {
                AntPathRequestMatcher antPathMatcher = new AntPathRequestMatcher(btnPermission.getUrl(), btnPermission.getMethod());
                if (antPathMatcher.matches(request)) {
                    hasPermission = true;
                    break;
                }
            }

            return hasPermission;
        } else {
            return false;
        }
    }

    private void checkRequest(HttpServletRequest request) {
        // Get current request method
        String currentMethod = request.getMethod();
        Multimap<String, String> urlMapping = allUrlMapping();

        for (String uri : urlMapping.keySet()) {
            // Match URL via AntPathRequestMatcher
            // There are 2 ways to create AntPathRequestMatcher
            // 1: new AntPathRequestMatcher(uri, method) This method can directly judge whether the method matches, because here we throw the method mismatch and customize it, so we use the second method
            // 2: new AntPathRequestMatcher(uri) This method does not verify the request method, only the request path
            AntPathRequestMatcher antPathMatcher = new AntPathRequestMatcher(uri);
            if (antPathMatcher.matches(request)) {
                if (!urlMapping.get(uri).contains(currentMethod)) {
                    throw new SecurityException(Status.HTTP_BAD_METHOD);
                } else {
                    return;
                }
            }
        }

        throw new SecurityException(Status.REQUEST_NOT_FOUND);
    }

    /**
     * Get all URL Mapping, the return format is {"/test":["GET","POST"],"/sys":["GET","DELETE"]}
     *
     * @return {@link ArrayListMultimap} URL Mapping in Format
     */
    private Multimap<String, String> allUrlMapping() {
        Multimap<String, String> urlMapping = ArrayListMultimap.create();

        // Get the corresponding information of url, class and method
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();

        handlerMethods.forEach((k, v) -> {
            // Get all URLs under the current key
            Set<String> url = k.getPatternsCondition().getPatterns();
            RequestMethodsRequestCondition method = k.getMethodsCondition();

            // Add all request methods for each URL
            url.forEach(s -> urlMapping.putAll(s, method.getMethods()
                    .stream()
                    .map(Enum::toString)
                    .collect(Collectors.toList())));
        });

        return urlMapping;
    }
}
