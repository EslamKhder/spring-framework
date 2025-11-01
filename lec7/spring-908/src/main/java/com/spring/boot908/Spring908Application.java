package com.spring.boot908;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Spring908Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring908Application.class, args);
	}

}
