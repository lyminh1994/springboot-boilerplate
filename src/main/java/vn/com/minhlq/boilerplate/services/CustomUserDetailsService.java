package vn.com.minhlq.boilerplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.minhlq.boilerplate.model.Permission;
import vn.com.minhlq.boilerplate.model.Role;
import vn.com.minhlq.boilerplate.model.User;
import vn.com.minhlq.boilerplate.repositories.PermissionRepository;
import vn.com.minhlq.boilerplate.repositories.RoleRepository;
import vn.com.minhlq.boilerplate.repositories.UserRepository;
import vn.com.minhlq.boilerplate.vo.UserPrincipal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Custom UserDetails Service
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.services
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmailOrPhone) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmailOrPhone(usernameOrEmailOrPhone, usernameOrEmailOrPhone, usernameOrEmailOrPhone)
                .orElseThrow(() -> new UsernameNotFoundException("User information not found : " + usernameOrEmailOrPhone));
        List<Role> roles = roleRepository.selectByUserId(user.getId());
        List<Long> roleIds = roles.stream()
                .map(Role::getId)
                .collect(Collectors.toList());
        List<Permission> permissions = permissionRepository.selectByRoleIdList(roleIds);
        return UserPrincipal.create(user, roles, permissions);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
