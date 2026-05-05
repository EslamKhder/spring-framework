package com.spring.demo.config;

import com.spring.demo.helper.BundleErrorMessage;
import com.spring.demo.helper.ErrorMessage;
import com.spring.demo.helper.InputErrorMessage;
import com.spring.demo.service.helper.BundleMessageService;
import jakarta.transaction.SystemException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {
//
//
//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<BundleErrorMessage> handelException(Throwable throwable){
//        return ResponseEntity.badRequest().body(BundleMessageService.getMessage(throwable.getMessage()));
//    }
//
//
////    @ExceptionHandler(MethodArgumentNotValidException.class)
////    public ResponseEntity<List<ErrorMessage>> handelException(MethodArgumentNotValidException exception){
////        List<ErrorMessage> errorMessages =
////                exception.getBindingResult().getFieldErrors().stream()
////                        .map(fieldError -> new ErrorMessage(fieldError.getDefaultMessage()))
////                        .collect(Collectors.toList());
////
////        return ResponseEntity.badRequest().body(errorMessages);
////    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<List<InputErrorMessage>> handelException(MethodArgumentNotValidException exception){
//        List<InputErrorMessage> errorMessages =
//                exception.getBindingResult().getFieldErrors().stream()
//                        .map(fieldError -> new InputErrorMessage(fieldError.getField(), BundleMessageService.getMessage(fieldError.getDefaultMessage())))
//                        .collect(Collectors.toList());
//
//        return ResponseEntity.badRequest().body(errorMessages);
//    }



    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handelException(Throwable throwable){
        return ResponseEntity.badRequest().body(BundleMessageService.getAcceptedLanguageMessage(throwable.getMessage()));
    }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<List<ErrorMessage>> handelException(MethodArgumentNotValidException exception){
//        List<ErrorMessage> errorMessages =
//                exception.getBindingResult().getFieldErrors().stream()
//                        .map(fieldError -> new ErrorMessage(fieldError.getDefaultMessage()))
//                        .collect(Collectors.toList());
//
//        return ResponseEntity.badRequest().body(errorMessages);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<InputErrorMessage>> handelException(MethodArgumentNotValidException exception){
        List<InputErrorMessage> errorMessages =
                exception.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> new InputErrorMessage(fieldError.getField(), BundleMessageService.getAcceptedLanguageMessage(fieldError.getDefaultMessage())))
                        .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorMessages);
    }
}
