package com.spring.start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*AnnotationConfigApplicationContext annotationContext = 
				new AnnotationConfigApplicationContext("applicationContext.xml");*/
		
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AdminServiceImpl s1 = applicationContext.getBean("adminServiceImpl", AdminServiceImpl.class);
		s1.save("ahmed");
		
		ClentServiceImpl2 s2 = applicationContext.getBean("clentServiceImpl2", ClentServiceImpl2.class);
		s2.save("ahmed");
	}

}
