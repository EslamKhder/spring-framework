package com.spring.boot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Schema(
        name = "Employee",
        description = "schema to hold employee data info"
)
@Setter
@Getter
public class EmployeeDto {


    private Long id;

    @Schema(
            description = "user name of employee and must be unique", example = "eraaSoft"
    )
    private String userName;
    @Schema(
            description = "password of employee", example = "eraaSoft@123"
    )
    private String password;

    private List<RoleDto> roleDtos;
}
