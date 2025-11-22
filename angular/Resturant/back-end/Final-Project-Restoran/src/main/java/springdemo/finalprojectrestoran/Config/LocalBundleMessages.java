package springdemo.finalprojectrestoran.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;


@Configuration
public class LocalBundleMessages {

    @Value("${spring.messages.basename}")  //  gets the value of the basename from the properties file
    private String baseName;

    @Value("${spring.messages.local-default}")
    private String  localDefault;


    @Bean("messages")
    public ResourceBundleMessageSource messageSource() {
        System.out.println("Here is the ResourceBundleMessageSource Bean created  in the config LocalBundleMessagas");

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename(baseName);
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);
        return source;

    }

    @Bean
    public LocaleResolver localResolver() {
        System.out.println("Here is the local Resolver Bean created  in the config LocalBundleMessagas");

        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(new Locale(localDefault)); // this localDefault is from the properties file
        return acceptHeaderLocaleResolver;
    }
}
