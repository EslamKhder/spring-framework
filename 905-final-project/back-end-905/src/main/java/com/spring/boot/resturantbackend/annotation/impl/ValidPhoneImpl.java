package com.spring.boot.resturantbackend.annotation.impl;

import com.spring.boot.resturantbackend.annotation.ValidPhone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class ValidPhoneImpl implements ConstraintValidator<ValidPhone, String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if (Objects.isNull(phone)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Phone cannot be null")
                    .addConstraintViolation();
            return false;
        }

        if (!phone.startsWith("+20")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Phone must start with +20")
                    .addConstraintViolation();
            return false;
        }

        if (phone.length() != 13) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Phone must be 13 digits long")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
