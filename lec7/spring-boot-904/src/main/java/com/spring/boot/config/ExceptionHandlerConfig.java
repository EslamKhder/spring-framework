package com.spring.boot.config;

import com.spring.boot.controller.vm.ExceptionResponseVm;
import com.spring.boot.dto.exception.BundleMessage;
import com.spring.boot.dto.exception.IdNotNullException;
import com.spring.boot.service.bundle.BundleTranslatorService;
import jakarta.transaction.SystemException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerConfig {

   /* @ExceptionHandler(IdNotNullException.class)
    public ResponseEntity<ExceptionResponseVm> handelSystemException(IdNotNullException exception){
        BundleMessage bundleMessage =  BundleTranslatorService.getBundleMessageInEnglishAndArabic(exception.getMessage());

        return ResponseEntity.badRequest().body(new ExceptionResponseVm(List.of(bundleMessage), HttpStatus.NOT_ACCEPTABLE));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseVm> handelBadRequestException(BadRequestException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponseVm(List.of(new BundleMessage(null, exception.getMessage())), HttpStatus.NOT_ACCEPTABLE));
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseVm> handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrorList = ex.getBindingResult().getFieldErrors();
        // not null , empty   min size
        List<String> errors = fieldErrorList.stream().map(fieldError -> BundleTranslatorService.getBundleMessage(fieldError.getDefaultMessage())).collect(Collectors.toList());

        return ResponseEntity
                .badRequest()
                .body(new ExceptionResponseVm(errors, HttpStatus.BAD_REQUEST));
    }
}
