package com.spring.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StudentDto {

    private Long id;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    //@NotBlank(message = "name must be not null")
    //@Min(value = 5, message = "")
    private String name;

    //@Pattern(regexp = "", message = "")
    private String password;

    private TeacherDto teacher;
    //@Email(message = "")
    //private String email;

    //@Future
   // private LocalDate localDate;

    //@Min(25)
    //private int age;

   // private Float GPA;

   // private double avgOfAge;


}
