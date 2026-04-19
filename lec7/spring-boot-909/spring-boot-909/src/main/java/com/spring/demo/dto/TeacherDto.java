package com.spring.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDto {
    private Long id;

    @NotBlank(message = "userName must be not null")
    private String userName;

    @NotBlank(message = "password must be not null")
    private String password;

    @Email(message = "email must be with format email (eslam@gmail.com)")
    @NotBlank(message = "email must be not null")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    private String lastName;

    private String salary;

    private String fullAddress;
    private String fullName;
    private float commission;
    private float commissionSalary;

}
