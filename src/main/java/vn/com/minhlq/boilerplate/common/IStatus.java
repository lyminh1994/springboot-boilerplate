package vn.com.minhlq.boilerplate.common;

/**
 * <p>
 * REST API Error code interface
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