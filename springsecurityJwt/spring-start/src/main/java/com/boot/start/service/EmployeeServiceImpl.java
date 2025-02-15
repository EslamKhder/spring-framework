package com.boot.start.service;

import com.boot.start.model.Employee;
import com.boot.start.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee getEmployeeByUSerName(String username) {
        return employeeRepo.findByName(username);
    }
}
