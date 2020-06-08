package vn.com.minhlq.boilerplate.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import vn.com.minhlq.boilerplate.constant.CommonConst;
import vn.com.minhlq.boilerplate.security.service.UserPrinciple;


/**
 * <p>
 * Spring Security General Tools
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.util
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
public class SecurityUtil {

    private SecurityUtil() {}

    /**
     * Get the username of the currently login user
     *
     * @return Username of currently login user
     */
    public static String getCurrentUsername() {
        UserPrinciple currentUser = getCurrentUser();
        return ObjectUtils.isEmpty(currentUser) ? CommonConst.ANONYMOUS_NAME : currentUser.getUsername();
    }

    /**
     * Get current login user information
     *
     * @return Current login user information, null when login is anonymous
     */
    public static UserPrinciple getCurrentUser() {
        Object userInfo = SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();
        if (userInfo instanceof UserDetails) {
            return (UserPrinciple) userInfo;
        }
        return null;
    }
}
