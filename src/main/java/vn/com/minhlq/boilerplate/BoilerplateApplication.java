package vn.com.minhlq.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-dev.properties")
@SpringBootApplication(scanBasePackages = "vn.com.minhlq.boilerplate")
public class BoilerplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoilerplateApplication.class, args);
    }

}
