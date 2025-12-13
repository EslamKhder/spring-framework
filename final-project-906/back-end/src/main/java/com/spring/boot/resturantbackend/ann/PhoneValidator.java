package com.spring.boot.resturantbackend.ann;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(Objects.isNull(value)){
            return false;
        }

        // +201113903660
        return value.startsWith("+20") && value.length() == 13;
    }
}
