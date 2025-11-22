package springdemo.finalprojectrestoran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springdemo.finalprojectrestoran.sittings.TokenConfig;

@SpringBootApplication
@EnableConfigurationProperties(TokenConfig.class)
public class FinalProjectRestoranApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectRestoranApplication.class, args);
    }

}
