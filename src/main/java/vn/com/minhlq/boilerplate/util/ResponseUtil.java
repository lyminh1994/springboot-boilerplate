package vn.com.minhlq.boilerplate.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import vn.com.minhlq.boilerplate.common.ApiResponse;
import vn.com.minhlq.boilerplate.exception.BaseException;
import vn.com.minhlq.boilerplate.constant.IStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * Response General Tools
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.util
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Slf4j
public class ResponseUtil {

    private ResponseUtil() {}

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

            // FIXME: BUG of hutool: JSONUtil.toJsonStr()
            //  When converting JSON to String, there is an error in the converted String when ignoring the null value
            response.getWriter().write(JSONUtil.toJsonStr(new JSONObject(ApiResponse.ofStatus(status, data), false)));
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

            // FIXME: BUG of hutool: JSONUtil.toJsonStr()
            //  When converting JSON to String, there is an error in the converted String when ignoring the null value
            response.getWriter().write(JSONUtil.toJsonStr(new JSONObject(ApiResponse.ofException(exception), false)));
        } catch (IOException e) {
            log.error("Response writes JSON exception，", e);
        }
    }
}
