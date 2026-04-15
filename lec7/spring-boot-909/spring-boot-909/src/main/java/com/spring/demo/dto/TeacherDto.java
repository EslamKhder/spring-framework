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

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @Email
    @NotBlank
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
