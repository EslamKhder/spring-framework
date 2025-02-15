package com.boot.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.parameters.P;

import java.util.Scanner;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class SpringStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStartApplication.class, args);
	}

}
