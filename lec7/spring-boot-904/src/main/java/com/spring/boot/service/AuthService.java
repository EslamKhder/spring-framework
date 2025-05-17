package com.spring.boot.service;

import com.spring.boot.controller.vm.TokenResponseVm;
import com.spring.boot.dto.EmployeeDto;
import jakarta.transaction.SystemException;

public interface AuthService {

    void signUp(EmployeeDto employeeDto) throws SystemException;
    TokenResponseVm login(EmployeeDto employeeDto) throws SystemException;
}
