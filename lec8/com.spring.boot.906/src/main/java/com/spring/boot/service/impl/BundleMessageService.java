package com.spring.boot.service.impl;

import com.spring.boot.helper.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleMessageService {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public BundleMessageService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static String getBundleMessageAr(String key){
        return messageSource.getMessage(key, null, new Locale("ar"));
    }

    public static String getBundleMessageEn(String key){
        return messageSource.getMessage(key, null, new Locale("en"));
    }


    public static ExceptionResponse getBundleMessage(String key){
        return new ExceptionResponse(
                getBundleMessageAr(key), getBundleMessageEn(key)
        );
    }
}
