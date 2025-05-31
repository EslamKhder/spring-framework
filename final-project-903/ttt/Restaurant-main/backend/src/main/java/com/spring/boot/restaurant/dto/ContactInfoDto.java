package com.spring.boot.restaurant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactInfoDto {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name can't be longer than 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 150, message = "Email can't be longer than 150 characters")
    private String email;

    @NotBlank(message = "Subject is required")
    @Size(max = 200, message = "Subject can't be longer than 200 characters")
    private String subject;

    @NotBlank(message = "Message is required")
    @Size(max = 1000, message = "Message can't be longer than 1000 characters")
    private String message;

    private Long userId;
}