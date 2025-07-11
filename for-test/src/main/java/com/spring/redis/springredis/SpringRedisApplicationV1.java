package com.spring.redis.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringRedisApplicationV1 {

    public static void main(String[] args) {
        System.out.println("hi");

        SpringApplication.run(SpringRedisApplicationV1.class, args);
    }


}
