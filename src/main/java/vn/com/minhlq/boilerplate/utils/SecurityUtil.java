package vn.com.minhlq.boilerplate.utils;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import vn.com.minhlq.boilerplate.common.Consts;
import vn.com.minhlq.boilerplate.dto.UserPrincipal;

/**
 * <p>
 * Spring Security工具类
 * </p>
 *
 * @package: com.xkcoding.rbac.security.util
 * @description: Spring Security工具类
 * @author: yangkai.shen
 * @date: Created in 2018-12-12 18:30
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public class SecurityUtil {
    /**
     * 获取当前登录用户用户名
     *
     * @return 当前登录用户用户名
     */
    public static String getCurrentUsername() {
        UserPrincipal currentUser = getCurrentUser();
        return ObjectUtil.isNull(currentUser) ? Consts.ANONYMOUS_NAME : currentUser.getUsername();
    }

    /**
     * 获取当前登录用户信息
     *
     * @return 当前登录用户信息，匿名登录时，为null
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
