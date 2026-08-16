package com.spring.core;

import org.springframework.stereotype.Component;
 
//@Component
public class EmployeeService implements SchoolService {
	@Override
    public void startApp() {
        System.out.println("startApp Employee");
	}
    
}
