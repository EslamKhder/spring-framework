package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*SystemService systemService = 
				applicationContext.getBean("systemService" , SystemService.class);
		systemService.start();
		
		/*SchoolServiceSystem schoolServiceSystem = 
				applicationContext.getBean("studentServiceSystem" , SchoolServiceSystem.class);
		schoolServiceSystem.startApp();*/
		
		/*schoolServiceSystem = applicationContext.getBean("teacherServiceSystem" , SchoolServiceSystem.class);
		schoolServiceSystem.startApp();*/
		
		StudentServiceSystem schoolServiceSystem1 = 
				applicationContext.getBean("studentServiceSystem" , StudentServiceSystem.class);
		System.out.println(schoolServiceSystem1.getServiceName());
		
		
		
		
	}

}
