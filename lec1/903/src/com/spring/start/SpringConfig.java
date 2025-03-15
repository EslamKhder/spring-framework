package com.spring.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.spring.start")
@PropertySource("classpath:data.properties")
public class SpringConfig {

	
	@Bean("client")
	public ClientService createClientService() {
		return new ClientService();
	}
	
	@Bean("admin")
	public AdminServiceImpl admin() {
		return new AdminServiceImpl(createClientService());
	}
}
