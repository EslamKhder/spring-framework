package com.eraasoft.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//Accept-Language
@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class SpringBoot905Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot905Application.class, args);
	}

}
