package com.spring.demo911.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

// RTEX
// NULL
// EX.....
public class HandelException {


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> exception(Throwable throwable){
        return ResponseEntity.badRequest().body(throwable.getMessage());
    }

}
