package com.spring.boot.config;

import com.spring.boot.controller.vm.ExceptionResponseVm;
import com.spring.boot.dto.BundleMessage.BundleMessage;
import com.spring.boot.exceptions.IdMisMatchException;
import com.spring.boot.service.BundleService.BundleTranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionConfig {

    @Autowired
    private BundleTranslatorService bundleTranslatorService;

    @ExceptionHandler(IdMisMatchException.class)
    public ResponseEntity<ExceptionResponseVm> handleSystemException(IdMisMatchException systemException){ // error.id.invalid
        BundleMessage bundleMessage = bundleTranslatorService.getBundleMessageInEnglishAndArabic(systemException.getMessage());
        return ResponseEntity.ok(new ExceptionResponseVm(List.of(bundleMessage), HttpStatus.NOT_ACCEPTABLE));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseVm> handleValidationExceptions(MethodArgumentNotValidException ex) {

        ExceptionResponseVm exceptions = new ExceptionResponseVm(new ArrayList<>(), HttpStatus.BAD_REQUEST);

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            try {
                exceptions.getErrorMessages().add(bundleTranslatorService.getBundleMessageInEnglishAndArabic(error.getDefaultMessage()));
            } catch (Exception exception) {
                exceptions.getErrorMessages().add(new BundleMessage(error.getDefaultMessage(), null));
            }

        }

        return ResponseEntity.ok(exceptions);
    }
}
