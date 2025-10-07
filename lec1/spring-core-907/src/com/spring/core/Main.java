package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		BankSystem baseSystem1 = applicationContext.getBean("system", BankSystem.class);
		baseSystem1.saveStudent("ahmed");
		
		
		applicationContext.close();
		//baseSystem1.startSystem();
		
		/*BaseSystem baseSystem2 = applicationContext.getBean("system", BaseSystem.class);
		//baseSystem2.startSystem();
		
		
		System.out.println(baseSystem1);
		System.out.println(baseSystem2);
		
		System.out.println(baseSystem1 == baseSystem2);
		/*SystemAction systemAction = applicationContext.getBean("systemAction", SystemAction.class);
		systemAction.startApplication();*/
	}

}
