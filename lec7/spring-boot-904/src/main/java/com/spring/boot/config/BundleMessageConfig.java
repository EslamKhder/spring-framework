package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleMessageConfig {

    public static final String UTF_8 = "UTF-8";
    @Value("${spring.messages.basename}")
    private String baseName;

    @Value("${spring.messages.default}")
    private String defaultLan;


    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename(baseName);
        resourceBundleMessageSource.setDefaultEncoding(UTF_8);
        resourceBundleMessageSource.setDefaultLocale(new Locale(defaultLan));
        return resourceBundleMessageSource;
    }

}
