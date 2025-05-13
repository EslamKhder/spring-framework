package com.spring.boot;

import com.spring.boot.dto.MathNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class SpringBoot903Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot903Application.class, args);
	}

}
