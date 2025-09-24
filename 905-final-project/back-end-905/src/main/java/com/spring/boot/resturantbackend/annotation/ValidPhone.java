package com.spring.boot.resturantbackend.annotation;



import com.spring.boot.resturantbackend.annotation.impl.ValidPhoneImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidPhoneImpl.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhone {
    String message() default "Invalid phone number. It must start with +20 and be 13 characters";

    Class <? >[] groups() default {};

    Class <? extends Payload>[] payload() default {};
}
