package com.boot.start.service;

import com.boot.start.dto.StudentDto;
import com.boot.start.model.Employee;
import com.boot.start.model.Student;
import com.boot.start.repo.EmployeeRepo;
import com.boot.start.repo.StudentRepo;
import com.boot.start.service.mapper.StudentMapper;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee getEmployeeByUSerName(String username) {
        return employeeRepo.findByName(username);
    }
}
