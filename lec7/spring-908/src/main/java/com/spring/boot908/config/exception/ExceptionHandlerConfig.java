package com.spring.boot908.config.exception;

import com.spring.boot908.helper.MessageResponse;
import com.spring.boot908.service.impl.BundleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @Autowired
    private BundleMessageService bundleMessageService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleException(Exception exception){//id.teacher.not.required
        return ResponseEntity.badRequest().body(
                bundleMessageService.getMessage(exception.getMessage())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageResponse>> handleRuntimeException(MethodArgumentNotValidException exception) {

        List<MessageResponse> messageRespons = new ArrayList<>();

        List<FieldError> fieldErrors  = exception.getBindingResult().getFieldErrors();

        fieldErrors.stream().forEach(fieldError -> {
            String message = fieldError.getDefaultMessage(); // userName.teacher.required
            messageRespons.add(bundleMessageService.getMessage(message));
        });


        return ResponseEntity.badRequest().body(messageRespons);
    }
}
