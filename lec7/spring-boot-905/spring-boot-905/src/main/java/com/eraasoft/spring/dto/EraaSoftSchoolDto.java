package com.eraasoft.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // default
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EraaSoftSchoolDto {
    private Long id;

    private String fullUserName;

    private String password;

    private Integer age;

}
