package com.spring.boot.restaurant.exception;

import com.spring.boot.restaurant.dto.BundleMessage;
import org.springframework.http.HttpStatus;

public class ConflictException extends BaseException {
    public ConflictException(BundleMessage bundleMessage) {
        super(bundleMessage, HttpStatus.CONFLICT.value());
    }
}
