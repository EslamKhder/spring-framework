package spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext
			= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HospitalService myService1 = applicationContext.getBean("hospital", HospitalService.class);
		HospitalService myService2 = applicationContext.getBean("hospital", HospitalService.class);

		System.out.println(myService1);
		System.out.println(myService2);
		
		
		
		
		
		
		
		
		/*myService.saveMember("ahmed");
		System.out.println(myService.getServiceName());
		
		applicationContext.close();
		*/
		//HospitalService hospitalService = new HospitalService();
		/*System.out.println("-----------------------");
		RepoService service = new TeacherService();

		service.save("ahmed");*/
        
	}
}
