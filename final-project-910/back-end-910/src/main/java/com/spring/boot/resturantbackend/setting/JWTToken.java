package com.spring.boot.resturantbackend.setting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@Setter
@Getter
@ConfigurationProperties(prefix = "token")
public class JWTToken {
    private String secret;
    private Duration time;
}
