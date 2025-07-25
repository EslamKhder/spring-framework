package com.eraasoft.spring.config;

import com.eraasoft.spring.controller.vm.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleRuntimeException1(Exception exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage()));
    }
}
