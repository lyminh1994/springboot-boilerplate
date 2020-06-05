package vn.com.minhlq.boilerplate.exception.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.common.BaseException;
import vn.com.minhlq.boilerplate.common.Status;

import javax.validation.ConstraintViolationException;

/**
 * <p>
 * Global unified exception handling
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.exception.handler
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String LOGGER_PREFIX = "[GlobalExceptionHandler]";

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ApiResponse handlerException(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            log.error(LOGGER_PREFIX + "NoHandlerFoundException: Request path {}, Request method {}", ((NoHandlerFoundException) e).getRequestURL(), ((NoHandlerFoundException) e).getHttpMethod());
            return ApiResponse.ofStatus(Status.REQUEST_NOT_FOUND);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            log.error(LOGGER_PREFIX + "HttpRequestMethodNotSupportedException: Current request method {}, Support request method {}", ((HttpRequestMethodNotSupportedException) e).getMethod(), JSONUtil.toJsonStr(((HttpRequestMethodNotSupportedException) e).getSupportedHttpMethods()));
            return ApiResponse.ofStatus(Status.HTTP_BAD_METHOD);
        } else if (e instanceof MethodArgumentNotValidException) {
            log.error(LOGGER_PREFIX + "MethodArgumentNotValidException", e);
            return ApiResponse.of(Status.BAD_REQUEST.getCode(), ((MethodArgumentNotValidException) e).getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage(), null);
        } else if (e instanceof ConstraintViolationException) {
            log.error(LOGGER_PREFIX + "ConstraintViolationException", e);
            return ApiResponse.of(Status.BAD_REQUEST.getCode(), CollUtil.getFirst(((ConstraintViolationException) e).getConstraintViolations())
                .getMessage(), null);
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            log.error(LOGGER_PREFIX + "MethodArgumentTypeMismatchException: Parameter name {}, Exception information {}", ((MethodArgumentTypeMismatchException) e).getName(), ((MethodArgumentTypeMismatchException) e).getMessage());
            return ApiResponse.ofStatus(Status.PARAM_NOT_MATCH);
        } else if (e instanceof HttpMessageNotReadableException) {
            log.error(LOGGER_PREFIX + "HttpMessageNotReadableException: Error message {}", ((HttpMessageNotReadableException) e).getMessage());
            return ApiResponse.ofStatus(Status.PARAM_NOT_NULL);
        } else if (e instanceof BadCredentialsException) {
            log.error(LOGGER_PREFIX + "BadCredentialsException: Error message {}", e.getMessage());
            return ApiResponse.ofStatus(Status.USERNAME_PASSWORD_ERROR);
        } else if (e instanceof DisabledException) {
            log.error(LOGGER_PREFIX + "BadCredentialsException: Error message {}", e.getMessage());
            return ApiResponse.ofStatus(Status.USER_DISABLED);
        } else if (e instanceof BaseException) {
            log.error(LOGGER_PREFIX + "DataManagerException: Status code {}, Exception information {}", ((BaseException) e).getCode(), e.getMessage());
            return ApiResponse.ofException((BaseException) e);
        }

        log.error(LOGGER_PREFIX + "Exception information {} ", e.getMessage());
        return ApiResponse.ofStatus(Status.ERROR);
    }
}
