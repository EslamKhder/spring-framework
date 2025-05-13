package com.spring.boot.spring903.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {


    @Bean
    public ModelMapper defineModelMapper(){
        return new ModelMapper();
    }
}
