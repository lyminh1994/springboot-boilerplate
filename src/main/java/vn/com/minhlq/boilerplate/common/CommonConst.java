package vn.com.minhlq.boilerplate.common;

/**
 * <p>
 * Constant pool
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.common
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
public interface CommonConst {

    /**
     * Enable
     */
    Integer ENABLE = 1;
    /**
     * Disable
     */
    Integer DISABLE = 0;

    /**
     * Page
     */
    Integer PAGE = 1;

    /**
     * Button
     */
    Integer BUTTON = 2;

    /**
     * JWT key prefix saved in Redis
     */
    String REDIS_JWT_KEY_PREFIX = "security:jwt:";

    /**
     * Symbol star
     */
    String SYMBOL_STAR = "*";

    /**
     * Symbol email
     */
    String SYMBOL_EMAIL = "@";

    /**
     * Default current page number
     */
    Integer DEFAULT_CURRENT_PAGE = 1;

    /**
     * Default number of pages per page
     */
    Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * Anonymous user username
     */
    String ANONYMOUS_NAME = "Anonymous User";
}
