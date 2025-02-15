package com.boot.start.service.auth;

import com.boot.start.config.JwtTokenHandler;
import com.boot.start.dto.TokenResponse;
import com.boot.start.dto.UserDto;
import com.boot.start.model.Employee;
import com.boot.start.service.EmployeeService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtTokenHandler jwtTokenHandler;


    @Override
    public TokenResponse login(UserDto userDto) throws SystemException {
        Employee employee = employeeService.getEmployeeByUSerName(userDto.getUserName());

        if (Objects.isNull(employee)) {
            throw new SystemException("User not found");
        }

        if (!employee.getPassword().equals(userDto.getPassword())){
            throw new SystemException("Invalid Password");
        }


        return new TokenResponse(jwtTokenHandler.createToken(employee));
    }

    @Override
    public TokenResponse createAccount(UserDto userDto) {
        return null;
    }
}
