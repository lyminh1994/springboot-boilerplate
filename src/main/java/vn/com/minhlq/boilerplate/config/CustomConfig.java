package vn.com.minhlq.boilerplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * 自定义配置
 * </p>
 *
 * @package: com.xkcoding.rbac.security.config
 * @description: 自定义配置
 * @author: yangkai.shen
 * @date: Created in 2018-12-13 10:56
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */

@Data
@ConfigurationProperties(prefix = "custom.config")
public class CustomConfig {
    /**
     * 不需要拦截的地址
     */
    private IgnoreConfig ignores;
}
