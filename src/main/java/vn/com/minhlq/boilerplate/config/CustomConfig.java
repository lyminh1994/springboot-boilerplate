package vn.com.minhlq.boilerplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "custom.config")
public class CustomConfig {
    /**
     * Addresses that do not need to be intercepted
     */
    private IgnoreConfig ignores;
}
