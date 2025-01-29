package com.spring.service;

import com.spring.dto.UserLoginDto;
import jakarta.transaction.SystemException;

public interface UserAuthService {

    String login(UserLoginDto userLoginDto) throws SystemException;
}
