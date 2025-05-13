package com.spring.boot.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDto {

    private Long id;

    private String roleName;

    private EmployeeDto employeeDto;

}
