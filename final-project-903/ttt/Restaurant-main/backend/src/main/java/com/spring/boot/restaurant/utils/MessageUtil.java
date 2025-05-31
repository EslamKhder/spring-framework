package com.spring.boot.restaurant.utils;

import org.springframework.context.MessageSource;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MessageUtil {
    public static Map<String, String> getBilingualMessageMap(MessageSource messageSource, String key) {
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("en", messageSource.getMessage(key, null, Locale.ENGLISH));
        messageMap.put("ar", messageSource.getMessage(key, null, new Locale("ar")));
        return messageMap;
    }
}
