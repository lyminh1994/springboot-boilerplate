package vn.com.minhlq.boilerplate.common;

import lombok.Data;

/**
 * <p>
 * Paging request parameters
 * </p>
 */
@Data
public class PageRequest {
    /**
     * Current page number
     */
    private Integer currentPage;

    /**
     * Number elements per page
     */
    private Integer pageSize;

}
