package spring.core.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/*
	 * diff 
	 * scope singleton with init method and destroy method.
	 * scope prototype with init method and destroy method why destroy method not do.
	 * */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ClientService clientService = applicationContext.getBean("client", ClientService.class);
		clientService.saveUser("ahmed");
		System.out.println(clientService.getUserName());
		
		applicationContext.close();
		/*UserService userService2 = applicationContext.getBean("client", UserService.class);
		System.out.println(userService2);
		
		
		System.out.println(userService1 == userService2);*/
	}

}
