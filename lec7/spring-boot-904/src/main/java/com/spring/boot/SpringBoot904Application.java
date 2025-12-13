package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class SpringBoot904Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot904Application.class, args);
    }

}
/**
 * Class<?>[] groups() default { };  // interface
 *
 *     Class<? extends Payload>[] payload() default { };
 *
 *
 */
