package com.spring.config;

import com.spring.dto.ExceptionResponse;
import com.spring.service.impl.BundleTranslatorService;
import jakarta.transaction.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handelException(Exception exception) {
        return ResponseEntity.ok("error because " + exception.getMessage());
    }

}
