package com.spring.boot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;

    @NotBlank(message = "student.name.required")
    private String name;

    @NotBlank(message = "student.username.required")
    private String userName;

    @NotBlank(message = "student.password.required")
    private String password;

    @NotBlank(message = "student.phone.required")
    private String phoneNumber;

    private List<RoleDto> roles;


}
