package vn.com.minhlq.boilerplate.common;

import lombok.Getter;

/**
 * <p>
 * General status code
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
@Getter
public enum Status implements IStatus {
    /**
     * Successful！
     */
    SUCCESS(200, "Successful！"),

    /**
     * Internal Server Error！
     */
    ERROR(500, "Internal Server Error！"),

    /**
     * Logout successfully！
     */
    LOGOUT(200, "Logout successfully！"),

    /**
     * Please log in first！
     */
    UNAUTHORIZED(401, "Please login first！"),

    /**
     * No access right now！
     */
    ACCESS_DENIED(403, "Insufficient permissions!"),

    /**
     * Request does not exist！
     */
    REQUEST_NOT_FOUND(404, "Request not found！"),

    /**
     * Request method is not supported！
     */
    HTTP_BAD_METHOD(405, "Request method not supported！"),

    /**
     * Request exception！
     */
    BAD_REQUEST(400, "Request exception！"),

    /**
     * Parameter does not match！
     */
    PARAM_NOT_MATCH(400, "Parameter does not match！"),

    /**
     * Parameter cannot be empty！
     */
    PARAM_NOT_NULL(400, "Parameter cannot be empty！"),

    /**
     * The current user has been locked, please contact the administrator to unlock!
     */
    USER_DISABLED(403, "The current user has been locked, please contact the administrator to unlock!"),

    /**
     * Wrong username or password！
     */
    USERNAME_PASSWORD_ERROR(5001, "Wrong username or password!"),

    /**
     * Token has expired, please login again!
     */
    TOKEN_EXPIRED(5002, "Token has expired, please login again!"),

    /**
     * Token analysis failed, please try to login again!
     */
    TOKEN_PARSE_ERROR(5002, "Token analysis failed, please try to login again!"),

    /**
     * The current user has logged in somewhere, please try to change the password or login again!
     */
    TOKEN_OUT_OF_CTRL(5003, "The current user has logged in somewhere, please try to change the password or login again!"),

    /**
     * Unable to kick out yourself manually, please try to logout!
     */
    KICK_OUT_SELF(5004, "Unable to kick out yourself manually, please try to logout!");

    /**
     * Status code
     */
    private final Integer code;

    /**
     * Messages
     */
    private final String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Status fromCode(Integer code) {
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return SUCCESS;
    }

    @Override
    public String toString() {
        return String.format(" Status:{code=%s, message=%s} ", getCode(), getMessage());
    }

}
