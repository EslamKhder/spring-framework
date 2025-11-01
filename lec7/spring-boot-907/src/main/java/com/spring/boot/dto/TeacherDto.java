package com.spring.boot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    private Long id;

    @NotBlank(message = "Name must be not null")
    private String name;

    @NotBlank(message = "UserName be not null")
    private String userName;

    @NotBlank(message = "Password be not null.")
    private String password;

    @NotBlank
    private String phoneNumber;

    private String conCatNameAndUserName;

    public TeacherDto(Long id, String name, String userName, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

}
