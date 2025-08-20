package com.eraasoft.spring.service.bundelmessage;


import com.eraasoft.spring.helper.BundleMessage;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleMessageService {

    private ResourceBundleMessageSource messageSource;

    public BundleMessageService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessageAr(String key){
        return messageSource.getMessage(key, null, new Locale("ar"));
    }

    public String getMessageEn(String key){
        return messageSource.getMessage(key, null, new Locale("en"));
    }

    public BundleMessage getMessageArEn(String key){
        return new BundleMessage(getMessageAr(key),getMessageEn(key));
    }

    public String getMessage(String key){ // key    ar , en
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    //
    //
}
