package com.spring.boot.spring903.dto;


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
