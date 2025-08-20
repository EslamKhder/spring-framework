package com.eraasoft.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "user.name.notnull")
    private String fullUserName;

    @NotBlank(message = "password.notnull")
    private String password;

    @NotNull(message = "age.notnull")
    @Min(value = 18, message = "age.min")
    @Max(value = 30, message = "age.max")
    private Integer age;

}
