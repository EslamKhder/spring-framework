package com.spring.boot.service.impl;

import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.mapper.EmployeeMapper;
import com.spring.boot.model.Employee;
import com.spring.boot.repo.EmployeeRepo;
import com.spring.boot.service.EmployeeService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public EmployeeDto getEmployeeByUserName(String userName) throws SystemException {
        if (Objects.isNull(userName)) {
            throw new SystemException("user name must be not null");
        }

        Optional<Employee> employee =  employeeRepo.findByUserName(userName);

        if (!employee.isPresent()) {
            throw new SystemException("user name not exist");
        }
        return EmployeeMapper.EMPLOYEE_MAPPER.toEmployeeDto(employee.get());
    }
}
