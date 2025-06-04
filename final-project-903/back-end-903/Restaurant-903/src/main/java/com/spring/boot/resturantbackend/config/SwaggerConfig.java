package com.spring.boot.resturantbackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "resturant-App",
                description = "to take order",
                version = "version 5",
                contact = @Contact(
                        name = "Eslam Khder",
                        email = "eslam@gmail.com",
                        url = "http://localhost:8080"
                ),
                license = @License(
                        url = "http://localhost:9090",
                        name = "resturant"
                )
        )
)
public class SwaggerConfig {

}
