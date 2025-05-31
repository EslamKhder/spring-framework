package com.spring.boot.restaurant.exception;

import com.spring.boot.restaurant.dto.BundleMessage;
import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {
        public BadRequestException(BundleMessage bundleMessage) {
        super(bundleMessage, HttpStatus.BAD_REQUEST.value());
    }

}