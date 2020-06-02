package vn.com.minhlq.boilerplate.utils;

import cn.hutool.core.util.ReflectUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.PageRequest;
import vn.com.minhlq.boilerplate.constant.Consts;
import vn.com.minhlq.boilerplate.common.PageCondition;


public class PageUtil {
    /**
     * Check paging parameter, is null, set default value of paging parameter
     *
     * @param condition Query parameters
     * @param clazz     Class
     * @param <T>       {@link PageCondition}
     */
    public static <T extends PageCondition> void checkPageCondition(T condition, Class<T> clazz) {
        if (ObjectUtils.isEmpty(condition)) {
            condition = ReflectUtil.newInstance(clazz);
        }
        // Verify paging parameters
        if (ObjectUtils.isEmpty(condition.getCurrentPage())) {
            condition.setCurrentPage(Consts.DEFAULT_CURRENT_PAGE);
        }
        if (ObjectUtils.isEmpty(condition.getPageSize())) {
            condition.setPageSize(Consts.DEFAULT_PAGE_SIZE);
        }
    }

    /**
     * Construct based on pagination parameters {@link PageRequest}
     *
     * @param condition Query parameters
     * @param <T>       {@link PageCondition}
     * @return {@link PageRequest}
     */
    public static <T extends PageCondition> PageRequest ofPageRequest(T condition) {
        return PageRequest.of(condition.getCurrentPage(), condition.getPageSize());
    }
}
