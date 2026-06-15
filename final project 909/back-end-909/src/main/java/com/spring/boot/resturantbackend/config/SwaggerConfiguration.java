package com.spring.boot.resturantbackend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Resturant Endpoints",
                description = "all apis for Resturant",
                contact = @Contact(
                        name = "Taher Elzoghby",
                        email = "tataamen678@gmail.com",
                        url = "https://www.linkedin.com/in/taher-elzoghby-99499b231/"
                ),
                license = @License(
                        name = "resturant license",
                        url = "http://localhost:4200"
                ),
                version = "1"
        )
)
public class SwaggerConfiguration {
}
