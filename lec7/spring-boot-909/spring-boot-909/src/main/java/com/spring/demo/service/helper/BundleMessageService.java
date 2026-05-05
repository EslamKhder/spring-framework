package com.spring.demo.service.helper;

import com.spring.demo.helper.BundleErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Component
public class BundleMessageService {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public BundleMessageService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static String getMessageAr(String code){
        return messageSource.getMessage(code, null, new Locale("ar"));
    }

    public static String getMessageEn(String code){
        return messageSource.getMessage(code, null, new Locale("en"));
    }

    public static String getMessage(String code, Locale locale){
        return messageSource.getMessage(code, null, locale);
    }

    public static BundleErrorMessage getMessage(String code){
        return new BundleErrorMessage(
                getMessageAr(code),
                getMessageEn(code)
        );
    }

    public static String getAcceptedLanguageMessage(String code){
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

}
