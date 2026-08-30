package com.spring.demo.ann;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PhoneNumberValidation implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {

        // 012
        // +201234a67894
        if (Objects.isNull(phoneNumber) || !phoneNumber.startsWith("+20") || phoneNumber.length() != 13){
            return false;
        }

        for (int i=3;i<=12;i++) {
            if (!(phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;

    }
}
