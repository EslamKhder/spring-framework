package springdemo.finalprojectrestoran.Config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import springdemo.finalprojectrestoran.Service.BundleService.BundleTranslatorService;
import springdemo.finalprojectrestoran.dto.BundleMessage.ExceptionResponseDto;

@ControllerAdvice
public class ExceptionHandeler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok(new ExceptionResponseDto(HttpStatus.BAD_REQUEST, BundleTranslatorService.getBundleMessageinEnglishAndArabic(ex.getMessage())));

    }
}
