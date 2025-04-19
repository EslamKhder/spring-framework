package com.spring.boot.service.BundleService;

import com.spring.boot.dto.BundleMessage.BundleMessage;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleTranslatorService {
   private static ResourceBundleMessageSource resourceBundleMessageSource;

    public BundleTranslatorService(ResourceBundleMessageSource resourceBundleMessageSource) {
        this.resourceBundleMessageSource = resourceBundleMessageSource;

    }

    public static BundleMessage getBundleMessageInEnglishAndArabic(String key) {

        return new BundleMessage(
                resourceBundleMessageSource.getMessage(key, null, new Locale("en")),
                resourceBundleMessageSource.getMessage(key, null,  new Locale("ar"))
        );
    }

}
