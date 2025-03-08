package com.spring.restaurant.service.Jwt;

import com.spring.restaurant.service.dto.Jwt.ClientLoginDto;
import com.spring.restaurant.service.dto.Jwt.TokenDto;
import jakarta.transaction.SystemException;

public interface AuthService {
    TokenDto login(ClientLoginDto clientLoginDto) throws SystemException;

}
