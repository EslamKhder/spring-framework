package com.boot.start.service.bundel;

import com.boot.start.dto.ExceptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class LocalBundleMessagesService {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public LocalBundleMessagesService(@Qualifier("messages") ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static ExceptionDto getMessages(String key){ // invaild.id
        return new ExceptionDto(
                messageSource.getMessage(key, null, new Locale("ar")), // ar en "" bnbmn
                messageSource.getMessage(key, null, new Locale("")) //
        );
    }

}
