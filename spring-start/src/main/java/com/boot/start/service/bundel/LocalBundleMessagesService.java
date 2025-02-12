package com.boot.start.service.bundel;

import com.boot.start.dto.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;


@Component
public class LocalBundleMessagesService {

    private static ResourceBundleMessageSource messageSource;
    private static HttpServletRequest request;
    @Autowired
    public LocalBundleMessagesService(@Qualifier("messages") ResourceBundleMessageSource messageSource,  HttpServletRequest request) {
        this.messageSource = messageSource;
        this.request = request;
    }

    public static ExceptionDto getMessages(String key){ // invaild.id
        String language = request.getHeader("Accept-Language");
        return new ExceptionDto(
                messageSource.getMessage(key, null, new Locale(language)), // ar en "" bnbmn
                messageSource.getMessage(key, null, new Locale("")) //
        );
    }

}
