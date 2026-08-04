package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.ioc.SchoolAppService;

public class Main {

	public static void main(String[] args) {
		/*EmployeeService employeeService = new EmployeeService();
		employeeService.startApp();*/

		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TeacherService teacherService = applicationContext.getBean("myTeacher", TeacherService.class);
		teacherService.startApp();
		
		/*
		System.out.println("--------------------------");
		StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
		studentService.getDatafromDb();
		
		System.out.println("--------------------------");
		applicationContext.close();
		
		
		/*
		EmployeeService employeeService1 = applicationContext.getBean("employeeService", TeacherService.class);
		
		System.out.println("employeeService1 ===> " + employeeService1.getConnection());
		employeeService1.connectToDb();
		System.out.println("employeeService1 ===> " + employeeService1.getConnection());
		
		System.out.println("---------------------");
		
		EmployeeService employeeService2 = applicationContext.getBean("employeeService", EmployeeService.class);
		System.out.println("employeeService2 ===> " +employeeService2.getConnection());

		System.out.println("---------------------");
		EmployeeService employeeService3 = applicationContext.getBean("employeeService", EmployeeService.class);
		System.out.println("employeeService3 ===> " +employeeService3.getConnection());
		employeeService3.closeConnection();
		
		System.out.println("---------------------");
		System.out.println("employeeService1 ===> " +employeeService1.getConnection());

		/*EmployeeService employeeService1 = applicationContext.getBean("employeeService", EmployeeService.class);
		EmployeeService employeeService2 = applicationContext.getBean("employeeService", EmployeeService.class);
		
		System.out.println(employeeService1);
		System.out.println(employeeService2);
		
		System.out.println(employeeService1 == employeeService2);*/
		
		/*
		SchoolService schoolService = applicationContext.getBean("schoolService", SchoolService.class);
		schoolService.startApp();*/
	}

}
