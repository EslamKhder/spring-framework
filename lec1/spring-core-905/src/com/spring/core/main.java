package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		StudentService studentService1 = 
				applicationContext.getBean("studentService", StudentService.class);
		
		studentService1.printData();
		
		applicationContext.close();
	}

}
