package com.spring.boot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDto {

    private Long id;

    @NotBlank(message = "teacher.name.notBlank")
    private String myName;

    @NotBlank(message = "teacher.username.notBlank")
    private String userName;

    @NotBlank(message = "teacher.password.notBlank")
    private String password;

    @NotBlank(message = "teacher.phoneNumber.notBlank")
    private String phoneNumber;

    private String conCatNameAndUserName;

    private List<RoleDto> roles;
    public TeacherDto(Long id, String name, String userName, String password, String phoneNumber) {
        this.id = id;
        this.myName = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

}
