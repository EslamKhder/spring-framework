package com.spring.restaurant.config;

import com.spring.restaurant.service.bundle.BundleTranslatorService;
import com.spring.restaurant.service.dto.BundleMessage.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandeler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok(new ExceptionResponseDto(HttpStatus.NO_CONTENT, BundleTranslatorService.getBundleMessageinEnglishAndArabic(ex.getMessage())));

    }
}
