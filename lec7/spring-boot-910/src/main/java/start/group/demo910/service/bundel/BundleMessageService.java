package start.group.demo910.service.bundel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import start.group.demo910.helper.ExceptionResponse;

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
    public static ExceptionResponse getMessage(String code){
        return new ExceptionResponse(getMessageAr(code), getMessageEn(code));
    }
}
