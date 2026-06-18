package spring.core.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("spring.core.service.impl")
@PropertySource("classpath:data.properties")
public class SpringConfig {
	
}
