package vn.com.minhlq.boilerplate.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>
 * Custom Configuration
 * </p>
 */
@Data
@Configuration
@PropertySource("classpath:custom.properties")
@ConfigurationProperties(prefix = "custom.config")
public class CustomConfig {
    /**
     * URL addresses that do not need check security
     */
    private IgnoreConfig ignores;
}
