package com.spring.boot.restaurant.exception;

import com.spring.boot.restaurant.dto.BundleMessage;
import com.spring.boot.restaurant.service.bundleService.BundleTranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final BundleTranslatorService translatorService;

    @Autowired
    public GlobalExceptionHandler(BundleTranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BundleMessage> handleBaseExceptions(BaseException ex) {
        return new ResponseEntity<>(ex.getBundleMessage(), HttpStatus.valueOf(ex.getStatusCode()));
    }

    // Handle validation errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BundleMessage> handleValidationErrors(MethodArgumentNotValidException ex) {
        BundleMessage message = translatorService.getBundleMessage("validation.failed");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }


    // Handle entity not found exceptions (e.g., findById().orElseThrow())
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<BundleMessage> handleNoSuchElement(NoSuchElementException ex) {
        BundleMessage message = translatorService.getBundleMessage("not.found");
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    // Handle illegal states (e.g., double booking)
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<BundleMessage> handleIllegalState(IllegalStateException ex) {
        BundleMessage message = translatorService.getBundleMessage("illegal.state");
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BundleMessage> handleBadRequest(BadRequestException ex) {
        return new ResponseEntity<>(ex.getBundleMessage(), HttpStatus.BAD_REQUEST);
    }

    // Fallback for any unhandled exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BundleMessage> handleGenericException(Exception ex) {
        BundleMessage message = translatorService.getBundleMessage("internal.error");
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}