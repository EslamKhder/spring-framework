package com.spring.boot.config;

import com.spring.boot.helper.ExceptionResponse;
import com.spring.boot.service.impl.BundleMessageService;
import jakarta.transaction.SystemException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exception){
        return ResponseEntity.badRequest().body(BundleMessageService.getBundleMessage(exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handleException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        List<ExceptionResponse> errorMessages = fieldErrors.stream().map(fieldError -> BundleMessageService.getBundleMessage(fieldError.getDefaultMessage())).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorMessages);
    }

}
