package com.spring.sitting;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@Getter
@Setter
@ConfigurationProperties(prefix = "management-token")
public class TokenConfig {

    private String secret;

    private Duration time;
}
