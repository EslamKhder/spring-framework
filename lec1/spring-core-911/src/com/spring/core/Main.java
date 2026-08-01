package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.ioc.SchoolAppService;

public class Main {

	public static void main(String[] args) {
		/*EmployeeService employeeService = new EmployeeService();
		employeeService.startApp();*/

		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		
		SchoolAppService schoolAppService = applicationContext.getBean("schoolAppService", SchoolAppService.class);
		schoolAppService.run();
		
		/*
		SchoolService schoolService = applicationContext.getBean("schoolService", SchoolService.class);
		schoolService.startApp();*/
	}

}
