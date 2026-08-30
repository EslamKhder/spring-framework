package com.spring.demo.ann;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidation.class)
public @interface PhoneNumber {

    String message() default "invalid phone number";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
