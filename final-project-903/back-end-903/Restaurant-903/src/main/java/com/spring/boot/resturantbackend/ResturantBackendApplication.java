package com.spring.boot.resturantbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableJpaAuditing(auditorAwareRef = "auditingAwareImpl")
public class ResturantBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResturantBackendApplication.class, args);
    }

}
