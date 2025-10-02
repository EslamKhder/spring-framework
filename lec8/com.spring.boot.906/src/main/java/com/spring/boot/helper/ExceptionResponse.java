package com.spring.boot.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private String messageAr;
    private String messageEn;


    public ExceptionResponse(String messageEn) {
        this.messageEn = messageEn;
    }
}
