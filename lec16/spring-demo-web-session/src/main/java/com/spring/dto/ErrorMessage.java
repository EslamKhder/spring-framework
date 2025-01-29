package com.spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

    private String fieldName;
    private String errorMessage;
}
