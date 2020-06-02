package vn.com.minhlq.boilerplate;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "vn.com.minhlq.boilerplate")
public class BoilerplateApplication {

    @Bean
    public LayoutDialect getLayoutDialect() {
        return new LayoutDialect();
    }

    public static void main(String[] args) {
        SpringApplication.run(BoilerplateApplication.class, args);
    }

}
