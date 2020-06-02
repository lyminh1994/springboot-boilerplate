package vn.com.minhlq.boilerplate.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.minhlq.boilerplate.common.BaseException;
import vn.com.minhlq.boilerplate.constant.Status;


@Data
@EqualsAndHashCode(callSuper = true)
public class SecurityException extends BaseException {
    public SecurityException(Status status) {
        super(status);
    }

    public SecurityException(Status status, Object data) {
        super(status, data);
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }

    public SecurityException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}
