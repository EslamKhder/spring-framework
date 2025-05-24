package com.spring.boot.service.impl;

import com.spring.boot.config.TokenHandler;
import com.spring.boot.controller.vm.TokenResponseVm;
import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.service.AuthService;
import com.spring.boot.service.EmployeeService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(EmployeeDto employeeDto) throws SystemException {
        employeeService.addEmployee(employeeDto);
    }

    @Override
    public TokenResponseVm login(EmployeeDto employeeDto) throws SystemException {
        EmployeeDto employeeExist = employeeService.getEmployeeByUserName(employeeDto.getUserName());
        if (!passwordEncoder.matches(employeeDto.getPassword(), employeeExist.getPassword())) {
            throw new SystemException("invalid password");
        }
        if (Objects.nonNull(employeeDto)) {
            return new TokenResponseVm(tokenHandler.createToken(employeeExist));
        }
        return null;
    }
}
