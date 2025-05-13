package com.spring.boot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmployeeDto {

    private Long id;

    private String userName;
    private String password;

    private List<RoleDto> roleDtos;
}
