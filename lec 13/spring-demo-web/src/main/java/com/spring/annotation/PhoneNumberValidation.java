package com.spring.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumberValidation {
    public String code() default "+20";
    public String message() default "Invalid Number";
    public String message1() default "Invalid Number1";

    Class<?>[] groups() default {};  // Allows specifying validation groups
    Class<? extends Payload>[] payload() default {};  // Allows attaching additional data
}
