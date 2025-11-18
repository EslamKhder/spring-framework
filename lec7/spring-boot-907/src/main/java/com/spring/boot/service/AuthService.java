package com.spring.boot.service;

import com.spring.boot.controller.vm.LoginRequestVM;
import com.spring.boot.controller.vm.LoginResponseVM;
import jakarta.transaction.SystemException;

public interface AuthService {
    LoginResponseVM login(LoginRequestVM requestVM) throws SystemException;
}
