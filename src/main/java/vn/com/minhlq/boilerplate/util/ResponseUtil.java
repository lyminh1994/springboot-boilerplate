package vn.com.minhlq.boilerplate.util;


import lombok.extern.slf4j.Slf4j;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.constant.IStatus;
import vn.com.minhlq.boilerplate.exception.BaseException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * Response General Tools
 * </p>
 */
@Slf4j
public class ResponseUtil {

    private ResponseUtil() {
    }

    /**
     * Write json to response
     *
     * @param response HttpServletResponse
     * @param status   IStatus
     * @param data     Object
     */
    public static void renderJson(HttpServletResponse response, IStatus status, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            response.getWriter().write(JSONUtil.toJsonStr(ApiResponse.ofStatus(status, data)));
        } catch (IOException e) {
            log.error("Response writes JSON exception，", e);
        }
    }

    /**
     * Write json to response
     *
     * @param response  HttpServletResponse
     * @param exception BaseException
     */
    public static void renderJson(HttpServletResponse response, BaseException exception) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);
            response.getWriter().write(JSONUtil.toJsonStr(ApiResponse.ofException(exception)));
        } catch (IOException e) {
            log.error("Response writes JSON exception，", e);
        }
    }
}
