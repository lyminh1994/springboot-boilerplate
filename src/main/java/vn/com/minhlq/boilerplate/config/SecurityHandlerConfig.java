package vn.com.minhlq.boilerplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;
import vn.com.minhlq.boilerplate.common.Status;
import vn.com.minhlq.boilerplate.utils.ResponseUtil;

/**
 * <p>
 * Security 结果处理配置
 * </p>
 *
 * @package: com.xkcoding.rbac.security.config
 * @description: Security 结果处理配置
 * @author: yangkai.shen
 * @date: Created in 2018-12-07 17:31
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */

@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> ResponseUtil.renderJson(response, Status.ACCESS_DENIED, null);
    }

}
