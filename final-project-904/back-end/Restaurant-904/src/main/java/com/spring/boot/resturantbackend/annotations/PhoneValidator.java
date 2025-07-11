package com.spring.boot.resturantbackend.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {

        if(Objects.isNull(phone)){
            return false;
        }

        // +201113903660
        return phone.startsWith("+20") && phone.length() == 13;
    }
}
