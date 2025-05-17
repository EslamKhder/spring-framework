package com.spring.boot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.boot.model.Account;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long specId;

    @NotBlank(message = "invalid.name")
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 11, max = 11, message = "invalid.phone")
    private String phone;

    @NotEmpty(message = "invalid.address")
    private String address;

    private int nameSize;

    private String password;
//    @Email
//    @NotNull
//    private String email;
}
