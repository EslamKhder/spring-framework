package com.spring.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TeacherDto {

    private Long id;

    private String name;

    private String password;

    private double salary;

    private List<StudentDto> students;


}
