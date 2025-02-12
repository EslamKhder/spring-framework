package com.boot.start.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    private Integer id;

    @NotBlank(message = "invalid.name")
    private String name;

    @NotBlank(message = "invalid.address")
    private String address;

}
