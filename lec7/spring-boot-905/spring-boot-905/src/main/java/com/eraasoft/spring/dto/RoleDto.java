package com.eraasoft.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

// select RoleDto
@Setter
@Getter
public class RoleDto {

    private Long id;

    private String roleName;

//    private AccountDto account;
}
