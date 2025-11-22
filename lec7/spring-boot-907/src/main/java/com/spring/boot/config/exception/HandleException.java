package com.spring.boot.config.exception;

import com.spring.boot.helper.MessageResponse;
import com.spring.boot.service.impl.BundleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private BundleMessageService bundleMessageService;


    @Autowired
    public HandleException(BundleMessageService bundleMessageService) {
        this.bundleMessageService = bundleMessageService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                bundleMessageService.getMessage(exception.getMessage())
        );
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageResponse>> handleException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

//        List<MessageResponse> messageResponses = fieldErrors.stream().map(fieldError ->
//                new MessageResponse(null, fieldError.getDefaultMessage())).collect(Collectors.toList());
//

        List<MessageResponse> messageResponses = fieldErrors.stream().map(fieldError ->
                bundleMessageService.getMessage(fieldError.getDefaultMessage())
        ).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(messageResponses);
    }



}
