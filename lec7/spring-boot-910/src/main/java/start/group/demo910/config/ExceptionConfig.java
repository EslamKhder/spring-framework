package start.group.demo910.config;

import jakarta.transaction.SystemException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import start.group.demo910.helper.ExceptionResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionConfig {

    // SystemException


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ExceptionResponse> handelException(Throwable throwable){
        return ResponseEntity.badRequest().body(new ExceptionResponse(throwable.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>> handelException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

        List<ExceptionResponse> exceptionResponses = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            exceptionResponses.add(new ExceptionResponse(fieldError.getDefaultMessage()));
        }

        return ResponseEntity.badRequest().body(exceptionResponses);
    }

}
