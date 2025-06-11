package com.spring.boot.resturantbackend.dto;

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
public class UserDetailsDto {
    private Long id;
    @NotEmpty(message = "not_empty.phone_number")
    private String phoneNumber;
    @Size(min = 16, max = 80, message = "error.age")
    private int age;
    @NotEmpty(message = "not_empty.address")
    private String address;
}
