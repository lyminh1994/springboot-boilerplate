package vn.com.minhlq.boilerplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>
 * Custom Configuration
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
@Data
@PropertySource("classpath:custom.properties")
@ConfigurationProperties(prefix = "custom.config")
public class CustomConfig {
    /**
     * Addresses that do not need to be intercepted
     */
    private IgnoreConfig ignores;
}
