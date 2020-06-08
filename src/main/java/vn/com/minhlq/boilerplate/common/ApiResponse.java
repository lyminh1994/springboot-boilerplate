package vn.com.minhlq.boilerplate.common;

import lombok.Data;
import vn.com.minhlq.boilerplate.constant.IStatus;
import vn.com.minhlq.boilerplate.constant.Status;
import vn.com.minhlq.boilerplate.exception.BaseException;

import java.io.Serializable;

/**
 * <p>
 * Common API response
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
@Data
public class ApiResponse implements Serializable {
    private static final long serialVersionUID = 8993485788201922830L;

    /**
     * Status code
     */
    private Integer code;

    /**
     * Return content
     */
    private String message;

    /**
     * Return data
     */
    private Object data;

    /**
     * No-argument constructor
     */
    private ApiResponse() {

    }

    /**
     * Full parameter constructor
     *
     * @param code    Status code
     * @param message Return content
     * @param data    Return data
     */
    private ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Construct a custom API to return
     *
     * @param code    Status code
     * @param message Return content
     * @param data    Return data
     * @return ApiResponse
     */
    public static ApiResponse of(Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }

    /**
     * Construct a successful API return without data
     *
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess() {
        return ofSuccess(null);
    }

    /**
     * Construct a successful API with data to return
     *
     * @param data Return data
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(Object data) {
        return ofStatus(Status.SUCCESS, data);
    }

    /**
     * Construct a successful and custom API message return
     *
     * @param message Return content
     * @return ApiResponse
     */
    public static ApiResponse ofMessage(String message) {
        return of(Status.SUCCESS.getCode(), message, null);
    }

    /**
     * Construct a stateful API return
     *
     * @param status Status {@link Status}
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status) {
        return ofStatus(status, null);
    }

    /**
     * Construct a stateful API with data to return
     *
     * @param status Status {@link IStatus}
     * @param data   Return data
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(IStatus status, Object data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    /**
     * Construct an exception API return
     *
     * @param t   Abnormal
     * @param <T> {@link BaseException} Subclass
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return of(t.getCode(), t.getMessage(), t.getData());
    }
}
