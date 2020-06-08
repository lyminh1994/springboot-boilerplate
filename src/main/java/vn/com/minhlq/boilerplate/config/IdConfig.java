package vn.com.minhlq.boilerplate.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Use for testing purpose only
 */
@Configuration
public class IdConfig {
    @Bean
    public Snowflake snowflake() {
        return IdUtil.createSnowflake(1, 1);
    }
}
