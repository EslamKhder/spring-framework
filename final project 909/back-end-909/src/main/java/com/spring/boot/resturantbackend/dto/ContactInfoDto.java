package com.spring.boot.resturantbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContactInfoDto {
    private Long id;
    @NotEmpty(message = "not_empty.name")
    @Size(min = 7, max = 100, message = "size.name")
    private String name;
    @Email(message = "not_valid.email")
    private String email;
    @NotEmpty(message = "not_empty.subject")
    private String subject;
    @NotEmpty(message = "not_empty.message")
    private String message;
}
