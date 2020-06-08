package vn.com.minhlq.boilerplate.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * <p>
 * JWT Configuration
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
@ConfigurationProperties(prefix = "jwt.config")
public class JwtConfig {
    /**
     * jwt encryption key, default value: xkcoding.
     */
    private String key = "xkcoding";

    /**
     * jwt expiration time, default value: 600000 {@code 10 minutes}.
     */
    private Long ttl = 600000L;

    /**
     * Turn on Remember me after jwt expires, the default value is 604800000 {@code 7 days}
     */
    private Long remember = 604800000L;
}
