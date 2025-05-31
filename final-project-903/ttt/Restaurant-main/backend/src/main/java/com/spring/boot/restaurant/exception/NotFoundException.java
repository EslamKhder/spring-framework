package com.spring.boot.restaurant.exception;

import com.spring.boot.restaurant.dto.BundleMessage;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(BundleMessage bundleMessage) {
        super(bundleMessage, HttpStatus.NOT_FOUND.value());
    }
}