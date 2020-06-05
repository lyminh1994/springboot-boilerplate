package vn.com.minhlq.boilerplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
@ConfigurationProperties(prefix = "custom.config")
public class CustomConfig {
    /**
     * Addresses that do not need to be intercepted
     */
    private IgnoreConfig ignores;
}
