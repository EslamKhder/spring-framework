package com.spring.restaurant.service.bundle;

import com.spring.restaurant.service.dto.BundleMessage.BundleMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleTranslatorService {
   private static ResourceBundleMessageSource resourceBundleMessageSource;

    public BundleTranslatorService(@Qualifier("messages") ResourceBundleMessageSource resourceBundleMessageSource) {
        this.resourceBundleMessageSource = resourceBundleMessageSource;

    }
    public static BundleMessage getBundleMessageinEnglishAndArabic(String key) {

        return new BundleMessage(
                resourceBundleMessageSource.getMessage(key, null, new Locale("en") ),
                resourceBundleMessageSource.getMessage(key, null,  new Locale("ar"))
        );


    }

}
