package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// IOCService  I O C Service      Student Service
		IOCService iocService = 
				applicationContext.getBean("iocService", IOCService.class);
		
		iocService.startApp();
		
		applicationContext.close();
	}

}
