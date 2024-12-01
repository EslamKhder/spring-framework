package com.spring;

import com.spring.sitting.TokenConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TokenConfig.class)
public class SpringDemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoWebApplication.class, args);
    }

}