package com.spring.boot.resturantbackend.annotations.impl;

import com.spring.boot.resturantbackend.annotations.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (Objects.isNull(value) || !value.startsWith("+20") || value.length() != 13) {
            return false;
        }

        // 0123456789101112
        // +201113903660
        // TODO validate all next is digit
        //  $#@
        for (int i=3;i<13;i++) {
            if (!(value.charAt(i) >= '0' && value.charAt(i) <= '9')) {
                return false;
            }
        }

        return true;
    }
}
