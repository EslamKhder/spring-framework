package com.spring.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValidation, String> {


    @Override
    public void initialize(PhoneNumberValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s == null) {
            return false;
        }

        boolean result = s.startsWith("+20");
        if (!result) {
            return false;
        }
        return true;
    }
}
