package com.spring.boot.restaurant.exception;

import com.spring.boot.restaurant.dto.BundleMessage;

public class BaseException extends RuntimeException {
    private final BundleMessage bundleMessage;
    private final int statusCode;

    public BaseException(BundleMessage bundleMessage, int statusCode) {
        super(bundleMessage.getMessageEn()); // this will be the default exception message
        this.bundleMessage = bundleMessage;
        this.statusCode = statusCode;
    }

    public BundleMessage getBundleMessage() {
        return bundleMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }
}