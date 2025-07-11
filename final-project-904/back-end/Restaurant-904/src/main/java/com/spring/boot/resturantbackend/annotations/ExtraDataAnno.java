package com.spring.boot.resturantbackend.annotations;

import jakarta.validation.Payload;

public class ExtraDataAnno {
    public static class Info implements Payload {}
    public static class PhoneNumberError implements Payload {}
}