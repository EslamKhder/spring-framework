package com.boot.start.service.auth;

import com.boot.start.dto.TokenResponse;
import com.boot.start.dto.UserDto;
import jakarta.transaction.SystemException;

public interface AuthService {


    TokenResponse login(UserDto userDto) throws SystemException;

    TokenResponse createAccount(UserDto userDto);
}
