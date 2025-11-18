package com.spring.boot.service.impl;

import com.spring.boot.helper.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleMessageService {

    private ResourceBundleMessageSource messageSource;


    @Autowired
    public BundleMessageService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessageAr(String key){
        return messageSource.getMessage(key, null, new Locale("ar"));
    }

    public String getMessageEn(String key){
        return messageSource.getMessage(key, null, new Locale("en"));
    }


    public MessageResponse getMessage(String key){
        return new MessageResponse(
                getMessageAr(key),
                getMessageEn(key)
        );
    }


}
