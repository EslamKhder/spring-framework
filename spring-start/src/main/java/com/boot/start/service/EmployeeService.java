package com.boot.start.service;

import com.boot.start.dto.StudentDto;
import com.boot.start.model.Employee;
import com.boot.start.model.Student;
import jakarta.transaction.SystemException;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByUSerName(String username);


}
