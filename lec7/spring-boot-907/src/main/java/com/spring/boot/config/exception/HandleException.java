package com.spring.boot.config.exception;

import com.spring.boot.helper.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandleException {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ExceptionResponse(exception.getMessage()));
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handleException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        List<ExceptionResponse> exceptionResponses = fieldErrors.stream().map(fieldError -> new ExceptionResponse(fieldError.getDefaultMessage())).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exceptionResponses);
    }



}
