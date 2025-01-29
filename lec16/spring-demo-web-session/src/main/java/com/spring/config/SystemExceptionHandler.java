package com.spring.config;

import com.spring.dto.ExceptionResponse;
import com.spring.service.impl.BundleTranslatorService;
import jakarta.transaction.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SystemExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<ExceptionResponse> handelException(SystemException exception) {
            return ResponseEntity.ok(new ExceptionResponse(HttpStatus.BAD_REQUEST, BundleTranslatorService.getMessageInEnglishAndArabic(exception.getMessage())));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handelException(RuntimeException exception) {
        return ResponseEntity.ok(new ExceptionResponse(HttpStatus.BAD_REQUEST,  BundleTranslatorService.getMessageInEnglishAndArabic(exception.getMessage())));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handelException(Exception exception) {
        return ResponseEntity.ok(new ExceptionResponse(HttpStatus.BAD_REQUEST,  BundleTranslatorService.getMessageInEnglishAndArabic(exception.getMessage())));
    }

}
