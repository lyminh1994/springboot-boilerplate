package vn.com.minhlq.boilerplate.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;
import vn.com.minhlq.boilerplate.constant.Status;
import vn.com.minhlq.boilerplate.util.ResponseUtil;

/**
 * <p>
 * Security result processing configuration
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.config
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> ResponseUtil.renderJson(response, Status.ACCESS_DENIED, null);
    }

}
