package vn.com.minhlq.boilerplate.util;

import cn.hutool.core.util.ReflectUtil;
import org.apache.commons.lang3.ObjectUtils;
import vn.com.minhlq.boilerplate.constant.CommonConst;
import vn.com.minhlq.boilerplate.common.PageRequest;

/**
 * <p>
 * Paging General Tools
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
public class PageUtil {

    private PageUtil() {}

    /**
     * Check the paging parameter, is NULL, set the default value of the paging parameter
     *
     * @param condition <T>
     * @param clazz     Class<T>
     * @param <T>       {@link PageRequest}
     */
    public static <T extends PageRequest> void checkPageCondition(T condition, Class<T> clazz) {
        if (ObjectUtils.isEmpty(condition)) {
            condition = ReflectUtil.newInstance(clazz);
        }
        // Verify paging parameters
        if (ObjectUtils.isEmpty(condition.getCurrentPage())) {
            condition.setCurrentPage(CommonConst.DEFAULT_CURRENT_PAGE);
        }
        if (ObjectUtils.isEmpty(condition.getPageSize())) {
            condition.setPageSize(CommonConst.DEFAULT_PAGE_SIZE);
        }
    }

    /**
     * Build according to pagination parameters{@link org.springframework.data.domain.PageRequest}
     *
     * @param condition Query parameters
     * @param <T>       {@link PageRequest}
     * @return {@link org.springframework.data.domain.PageRequest}
     */
    public static <T extends PageRequest> org.springframework.data.domain.PageRequest ofPageRequest(T condition) {
        return org.springframework.data.domain.PageRequest.of(condition.getCurrentPage(), condition.getPageSize());
    }
}
