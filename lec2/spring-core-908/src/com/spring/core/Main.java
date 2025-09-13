package com.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ClassPathXmlApplicationContext applicationContext  = 
				new ClassPathXmlApplicationContext("applicationContext.xml");*/
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		
		AccountServiceApp accountServiceApp =  
				applicationContext.getBean("accountServiceApp", AccountServiceApp.class);
		
		
		accountServiceApp.startApp();
		applicationContext.close();
		
	}

}
