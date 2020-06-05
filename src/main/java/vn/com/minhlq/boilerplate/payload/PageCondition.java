package vn.com.minhlq.boilerplate.payload;

import lombok.Data;

/**
 * <p>
 * Paging request parameters
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.payload
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Data
public class PageCondition {
    /**
     * Current page number
     */
    private Integer currentPage;

    /**
     * Number elements per page
     */
    private Integer pageSize;

}
