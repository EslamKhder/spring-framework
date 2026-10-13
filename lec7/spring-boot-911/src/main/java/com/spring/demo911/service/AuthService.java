package com.spring.demo911.service;

import com.spring.demo911.controller.vm.LoginRequest;
import jakarta.transaction.SystemException;

public interface AuthService {

    String login(LoginRequest request) throws SystemException;
}
