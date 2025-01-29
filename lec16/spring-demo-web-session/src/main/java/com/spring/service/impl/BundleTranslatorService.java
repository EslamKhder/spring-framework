package com.spring.service.impl;

import com.spring.dto.BundleMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleTranslatorService {

    private static ResourceBundleMessageSource resourceBundleMessageSource;


    public BundleTranslatorService(@Qualifier("messages") ResourceBundleMessageSource resourceBundleMessageSource) {
        this.resourceBundleMessageSource = resourceBundleMessageSource;
    }

    public static String getMessage(String code){
        Locale locale = LocaleContextHolder.getLocale();
        return resourceBundleMessageSource.getMessage(code, null, locale);
    }

    public static BundleMessage getMessageInEnglishAndArabic(String code){
        return new BundleMessage(
                resourceBundleMessageSource.getMessage(code, null, new Locale("en")),
                resourceBundleMessageSource.getMessage(code, null, new Locale("ar"))
        );
    }
}
