package vn.com.minhlq.boilerplate.util;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import vn.com.minhlq.boilerplate.common.Consts;
import vn.com.minhlq.boilerplate.vo.UserPrincipal;


/**
 * <p>
 * Spring Security tools
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
public final class SecurityUtil {

    private SecurityUtil() {

    }

    /**
     * Get the username of the currently logged in user
     *
     * @return Username of currently logged in user
     */
    public static String getCurrentUsername() {
        UserPrincipal currentUser = getCurrentUser();
        return ObjectUtil.isNull(currentUser) ? Consts.ANONYMOUS_NAME : currentUser.getUsername();
    }

    /**
     * Get current login user information
     *
     * @return Current login user information, null when logging in anonymously
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
