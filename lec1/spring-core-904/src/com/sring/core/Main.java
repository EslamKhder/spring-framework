package com.sring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext applicationContext = new 
				AnnotationConfigApplicationContext(SpringConfig.class);
		
		/*SchoolService dbConnection1 = applicationContext.getBean("privateSchoolImpl", SchoolService.class);
		SchoolService dbConnection2 = applicationContext.getBean("publicSchoolImpl", SchoolService.class);*/
		DBConnection dBConnection1 = applicationContext.getBean("buildDBConnection", DBConnection.class);
		DBConnection dBConnection2 = applicationContext.getBean("buildDBConnection", DBConnection.class);
		//System.out.println(dBConnection1 == dBConnection2);
		dBConnection1.print();
		System.out.println(dBConnection1.getName());
		applicationContext.close();
	}

}
