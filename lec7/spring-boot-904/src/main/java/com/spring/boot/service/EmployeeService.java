package com.spring.boot.service;

import com.spring.boot.dto.AccountDto;
import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.dto.exception.IdNotNullException;
import com.spring.boot.model.Employee;
import jakarta.transaction.SystemException;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployeeByUserName(String userName) throws SystemException;
}
