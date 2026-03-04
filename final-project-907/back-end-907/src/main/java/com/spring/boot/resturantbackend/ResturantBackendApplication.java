package com.spring.boot.resturantbackend;

import com.spring.boot.resturantbackend.models.Product;
import jakarta.validation.Payload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// +201113903660
//
@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class ResturantBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResturantBackendApplication.class, args);
    }

}

//        Class<?>[] groups() default { };
//
//        Class<? extends Payload>[] payload() default { };