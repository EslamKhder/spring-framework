package com.spring.boot.resturantbackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Resturant EndPoints",
                description = "all apis for Resturant",
                contact = @Contact(
                        name = "Eslam Khder",
                        email = "eslamkhder11@gmail.com",
                        url = "https://www..com"
                ),
                version = "10"
        )
)
public class SwaggerConfiguration {
}
