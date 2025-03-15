package com.spring.start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationContext = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		/*ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		*/
		AdminServiceImpl s1 = annotationContext.getBean("admin", AdminServiceImpl.class);
		
		s1.save("ahmed");
		
		//System.out.println(s1.getUserName());
	}

}
