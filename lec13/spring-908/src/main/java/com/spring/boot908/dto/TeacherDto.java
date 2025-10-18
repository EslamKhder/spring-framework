package com.spring.boot908.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.boot908.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDto {

    private Long teacherId;

    @NotBlank(message = "userName.teacher.required")
    private String userName;

    @NotBlank(message = "password.teacher.required")
    private String password;

    private String conCatUserNameAndPassword;

    private Gender gender;

    private List<RoleDto> roles;
}
