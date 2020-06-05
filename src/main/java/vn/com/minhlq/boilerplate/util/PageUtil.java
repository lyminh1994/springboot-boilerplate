package vn.com.minhlq.boilerplate.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import org.springframework.data.domain.PageRequest;
import vn.com.minhlq.boilerplate.common.Consts;
import vn.com.minhlq.boilerplate.payload.PageCondition;

/**
 * <p>
 * Paging tools
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
    /**
     * Check the paging parameter, is NULL, set the default value of the paging parameter
     *
     * @param condition Query parameters
     * @param clazz     Class
     * @param <T>       {@link PageCondition}
     */
    public static <T extends PageCondition> void checkPageCondition(T condition, Class<T> clazz) {
        if (ObjectUtil.isNull(condition)) {
            condition = ReflectUtil.newInstance(clazz);
        }
        // Verify paging parameters
        if (ObjectUtil.isNull(condition.getCurrentPage())) {
            condition.setCurrentPage(Consts.DEFAULT_CURRENT_PAGE);
        }
        if (ObjectUtil.isNull(condition.getPageSize())) {
            condition.setPageSize(Consts.DEFAULT_PAGE_SIZE);
        }
    }

    /**
     * Build according to pagination parameters{@link PageRequest}
     *
     * @param condition Query parameters
     * @param <T>       {@link PageCondition}
     * @return {@link PageRequest}
     */
    public static <T extends PageCondition> PageRequest ofPageRequest(T condition) {
        return PageRequest.of(condition.getCurrentPage(), condition.getPageSize());
    }
}
