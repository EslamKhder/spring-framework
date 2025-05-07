package com.spring.boot.service.bundle;

import com.spring.boot.dto.exception.BundleMessage;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleTranslatorService {
   private static ResourceBundleMessageSource resourceBundleMessageSource;

    public BundleTranslatorService(ResourceBundleMessageSource resourceBundleMessageSource) {
        this.resourceBundleMessageSource = resourceBundleMessageSource;
    }


    /*
    case 1 : send Accept-Language  will use Accept-Language as is (ar, en)
    case 2 : not send Accept-Language  will use Accept-Language as en
    case 3 :  send Accept-Language  not (ar, en)   (fr)
     */
    public static String getBundleMessage(String key) {
        return resourceBundleMessageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public static String getBundleMessageInEnglish(String key) {

//        BundleMessage bundleMessage = new BundleMessage();

        return resourceBundleMessageSource.getMessage(key, null, new Locale("en"));
    }

/*
    public static BundleMessage getBundleMessage(String key, Locale locale) {


        return new BundleMessage(
                null,
                resourceBundleMessageSource.getMessage(key, null, locale)
        );
    }
    public static BundleMessage getBundleMessageInEnglish(String key, Locale locale) {


        return new BundleMessage(
                null,
                resourceBundleMessageSource.getMessage(key, null, locale)
        );
    }

    public static BundleMessage getBundleMessageInArabic(String key) {

        return new BundleMessage(
                resourceBundleMessageSource.getMessage(key, null,  new Locale("ar")),
                null
        );
    }
*/
}
