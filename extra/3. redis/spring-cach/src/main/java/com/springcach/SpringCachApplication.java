package com.springcach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCachApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCachApplication.class, args);
    }

}
