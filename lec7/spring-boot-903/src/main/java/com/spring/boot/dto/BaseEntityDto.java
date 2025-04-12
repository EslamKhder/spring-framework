package com.spring.boot.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntityDto {

    private Long id;
    private String userName;

    private String phoneNumber;
    private String length;
}
