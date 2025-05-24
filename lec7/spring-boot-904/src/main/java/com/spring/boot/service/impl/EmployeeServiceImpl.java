package com.spring.boot.service.impl;

import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.dto.RoleDto;
import com.spring.boot.enums.RoleSystem;
import com.spring.boot.mapper.EmployeeMapper;
import com.spring.boot.model.Employee;
import com.spring.boot.model.Role;
import com.spring.boot.repo.EmployeeRepo;
import com.spring.boot.service.EmployeeService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private @Lazy PasswordEncoder passwordEncoder;

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

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) throws SystemException {
        Optional<Employee> employeeExist =  employeeRepo.findByUserName(employeeDto.getUserName());

        if (employeeExist.isPresent()) {
            throw new SystemException("user already exist with same user name");
        }

        Employee employee = EmployeeMapper.EMPLOYEE_MAPPER.toEmployee(employeeDto);

        Role role = new Role();
        role.setRoleName(RoleSystem.USER.getRoleName());
        role.setEmployee(employee);
        employee.setRoles(List.of(role));

        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Employee savedEmployee = employeeRepo.save(employee);
        return EmployeeMapper.EMPLOYEE_MAPPER.toEmployeeDto(savedEmployee);
    }
}
