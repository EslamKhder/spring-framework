package com.spring.boot.restaurant.service.bundleService;

import com.spring.boot.restaurant.dto.BundleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleTranslatorService {
    private final ResourceBundleMessageSource messageSource;

    @Autowired
    public BundleTranslatorService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public BundleMessage getBundleMessage(String key) {
        return new BundleMessage(
                messageSource.getMessage(key, null, Locale.ENGLISH),
                messageSource.getMessage(key, null, new Locale("ar"))
        );
    }
}
