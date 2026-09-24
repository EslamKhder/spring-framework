package com.spring.demo911.service.bundlemessage;

import com.spring.demo911.helper.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleMessageService {

    @Autowired
    private ResourceBundleMessageSource messageSource;


    public String getMessageAr(String code){
        return messageSource.getMessage(code, null, new Locale("ar"));
    }

    public String getMessageEn(String code){
        return messageSource.getMessage(code, null, new Locale("En"));
    }

    public MessageResponse getMessage(String code){
        return new MessageResponse(getMessageAr(code), getMessageEn(code));
    }


}
//player.id.not.required  ---> value