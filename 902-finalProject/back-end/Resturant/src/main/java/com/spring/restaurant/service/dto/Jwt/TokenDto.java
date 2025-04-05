package com.spring.restaurant.service.dto.Jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TokenDto {

    private String token;

    private List<String> roles;
}
