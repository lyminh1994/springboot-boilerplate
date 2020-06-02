package vn.com.minhlq.boilerplate.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import vn.com.minhlq.boilerplate.constant.Consts;
import vn.com.minhlq.boilerplate.dto.UserPrincipal;


public class SecurityUtil {
    /**
     * Get the username of the currently logged in user
     *
     * @return Username of currently logged in user
     */
    public static String getCurrentUsername() {
        UserPrincipal currentUser = getCurrentUser();
        return ObjectUtils.isNotEmpty(currentUser) ? Consts.ANONYMOUS_NAME : currentUser.getUsername();
    }

    /**
     * Get current logged-in user information
     *
     * @return Current logged-in user information, null when logging in anonymously
     */
    public static UserPrincipal getCurrentUser() {
        Object userInfo = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if (userInfo instanceof UserDetails) {
            return (UserPrincipal) userInfo;
        }
        return null;
    }
}
