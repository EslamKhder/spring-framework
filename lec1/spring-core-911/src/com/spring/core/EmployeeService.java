package com.spring.core;

public class EmployeeService implements SchoolService {
    @Override
    public void startApp() {
        System.out.println("startApp Employee");
    }
}
