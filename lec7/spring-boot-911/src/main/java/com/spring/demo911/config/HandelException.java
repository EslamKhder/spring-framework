package com.spring.demo911.config;

import com.spring.demo911.helper.MessageResponse;
import com.spring.demo911.service.bundlemessage.BundleMessageService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice

// RTEX
// NULL
// EX.....
public class HandelException {

    @Autowired
    private BundleMessageService bundleMessageService;

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<MessageResponse> exception(Throwable throwable){
        return ResponseEntity.badRequest().body(bundleMessageService.getMessage(throwable.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageResponse>> exception(MethodArgumentNotValidException exception) {
        List<MessageResponse> messageResponses = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError ->
                        bundleMessageService.getMessage(fieldError.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(messageResponses);
    }

//    public ResponseEntity<List<MessageResponse>> exception(MethodArgumentNotValidException exception){
//        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
//
//        List<MessageResponse> messageResponses = new ArrayList<>();
//
//        for(FieldError fieldError: fieldErrors){
//            String errorMessage = fieldError.getDefaultMessage(); // player.invalid.name
//            messageResponses.add(new MessageResponse(null, errorMessage));
//        }
//
//
//        return ResponseEntity.badRequest().body(messageResponses);
//    }




}
