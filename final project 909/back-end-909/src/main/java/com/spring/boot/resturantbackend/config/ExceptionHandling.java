package com.spring.boot.resturantbackend.config;

import com.spring.boot.resturantbackend.dto.ExceptionDto;
import com.spring.boot.resturantbackend.models.BundleMessage;
import com.spring.boot.resturantbackend.services.BundleTranslationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionDto(
                        BundleTranslationService.getBundleMessageWithArAndEn(exception.getMessage())
                )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleValidationException(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldErrors().get(0);
        String error = fieldError.getDefaultMessage();
        BundleMessage bundleMessage = BundleTranslationService.getBundleMessageWithArAndEn(error);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ExceptionDto(bundleMessage));
    }
}
