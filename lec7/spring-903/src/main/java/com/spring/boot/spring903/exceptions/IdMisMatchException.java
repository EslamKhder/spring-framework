package com.spring.boot.spring903.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdMisMatchException extends Exception {

    public IdMisMatchException(String message) {
        super(message);
    }
}
