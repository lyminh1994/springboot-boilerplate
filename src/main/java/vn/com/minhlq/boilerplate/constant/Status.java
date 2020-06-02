package vn.com.minhlq.boilerplate.constant;

import lombok.Getter;


@Getter
public enum Status implements IStatus {

    SUCCESS(200, "Successful!"),

    ERROR(500, "Error!"),

    LOGOUT(200, "Exit successfully!"),

    UNAUTHORIZED(401, "Please Login first!"),

    ACCESS_DENIED(403, "Insufficient permissions!"),

    REQUEST_NOT_FOUND(404, "The request does not exist!"),

    HTTP_BAD_METHOD(405, "Request method is not supported!"),

    BAD_REQUEST(400, "The request is abnormal!"),

    PARAM_NOT_MATCH(400, "The parameters do not match!"),

    PARAM_NOT_NULL(400, "The parameter cannot be empty!"),

    USER_DISABLED(403, "The current user has been locked. Please contact the administrator to unlock!"),

    USERNAME_PASSWORD_ERROR(5001, "Invalid Username or Password!"),

    TOKEN_EXPIRED(5002, "Token has expired. Please log in again!"),

    TOKEN_PARSE_ERROR(5002, "Token analysis failed. Please try to Login again!"),

    TOKEN_OUT_OF_CTRL(5003, "The current user has logged in somewhere. Please try to change the password or login again!"),

    KICK_OUT_SELF(5004, "Manual kick out. Please try to login again!");

    private final Integer code;

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
