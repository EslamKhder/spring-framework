package com.spring.boot908.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private Long id;

    private String userName;

    private String password;

    private String conCatUserNameAndPassword;

    public TeacherDto(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public TeacherDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
