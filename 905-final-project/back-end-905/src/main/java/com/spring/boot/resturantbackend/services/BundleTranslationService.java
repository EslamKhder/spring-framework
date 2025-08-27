package com.spring.boot.resturantbackend.services;

import com.spring.boot.resturantbackend.models.BundleMessage;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleTranslationService {
    private static ResourceBundleMessageSource messageSource;

    public BundleTranslationService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static BundleMessage getBundleMessageWithArAndEn(String key) {
        try {
            return new BundleMessage(
                    messageSource.getMessage(key, null, new Locale("ar"))
                    ,
                    messageSource.getMessage(key, null, new Locale("en"))
            );
        } catch (Exception e){
            return new BundleMessage(key);
        }


    }
}
