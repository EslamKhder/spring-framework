package com.spring.config;


import com.spring.dto.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessage>> handelException(MethodArgumentNotValidException exception) {
        List<ObjectError> objectErrorList = exception.getBindingResult().getAllErrors();

//        Map<String, String> errors = new LinkedHashMap<>();
        List<ErrorMessage> errorMessages = new ArrayList<>();
        for (ObjectError objectError: objectErrorList) {
            String fieldName = ((FieldError)objectError).getField();
            String errorMessage = objectError.getDefaultMessage();

            ErrorMessage error = new ErrorMessage();
            error.setFieldName(fieldName);
            error.setErrorMessage(errorMessage);

            errorMessages.add(error);
//            errors.put(fieldName, errorMessage);
        }


        return ResponseEntity.ok(errorMessages);
    }

}
