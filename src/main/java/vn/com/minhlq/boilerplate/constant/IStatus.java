package vn.com.minhlq.boilerplate.constant;

/**
 * <p>
 * REST API Error code interface
 * </p>
 */
public interface IStatus {

    /**
     * Status code
     *
     * @return status
     */
    Integer getCode();

    /**
     * Messages
     *
     * @return message
     */
    String getMessage();

}