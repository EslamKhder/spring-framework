package com.boot.start.config;

import com.boot.start.dto.ExceptionDto;
import com.boot.start.service.bundel.LocalBundleMessagesService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

//@ControllerAdvice
@RestControllerAdvice
public class ExceptionHandlerConfig /*extends ResponseEntityExceptionHandler*/ {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ExceptionDto> handleSystemException(RuntimeException runtimeException){
        return ResponseEntity.internalServerError().body(LocalBundleMessagesService.getMessages(runtimeException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<List<ExceptionDto>> handleSystemException(MethodArgumentNotValidException methodArgumentNotValidException){
        List <FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

        List<ExceptionDto> exceptionDtos = new ArrayList<>();
        for (FieldError error: fieldErrors) {
            exceptionDtos.add(LocalBundleMessagesService.getMessages(error.getDefaultMessage()));
        }

        return ResponseEntity.internalServerError().body(exceptionDtos);
    }

}
