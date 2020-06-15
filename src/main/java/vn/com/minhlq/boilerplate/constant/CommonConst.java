package vn.com.minhlq.boilerplate.constant;

/**
 * <p>
 * Constant pool
 * </p>
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
