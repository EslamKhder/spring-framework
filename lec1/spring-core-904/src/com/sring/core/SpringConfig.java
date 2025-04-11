package com.sring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.sring.core")
@PropertySource("classpath:data2.properties")
public class SpringConfig {

	@Bean
	public DBConnection buildDBConnection() {
		return new DBConnection();
	}
	
}
