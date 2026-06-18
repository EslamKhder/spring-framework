package spring.core.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.service.impl.AccountService;
import spring.core.service.impl.FacebookAccountImpl;
import spring.core.service.impl.InstagramAccountImpl;
import spring.core.service.impl.SocialAccount;
import spring.core.service.impl.SpringConfig;
import spring.core.service.impl.StudentService;

public class Main {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(SpringConfig.class);
		
		StudentService studentService = applicationContext.getBean("studentService", StudentService.class);

		System.out.println(studentService.getName());
		
		/*FacebookAccountImpl accountImpl = new FacebookAccountImpl();
		accountImpl.createPost(1L, "bla bla bla");*/
		
		/*ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AnnotationConfigApplicationContext applicationContext 
			= new AnnotationConfigApplicationContext(SpringConfig.class);

		
		FacebookAccountImpl sacebookAccountImpl = applicationContext.getBean("fff", FacebookAccountImpl.class);
		
		
		sacebookAccountImpl.createAccount("Sss", "ss");
		
		applicationContext.close();
		
		/*
		AccountService accountImpl2 = applicationContext.getBean("facebook", AccountService.class);
		
		System.out.println(accountImpl1);
		System.out.println(accountImpl2);
		
		System.out.println(accountImpl1 == accountImpl2);
		AccountService accountImpl = applicationContext.getBean("facebookAccount", AccountService.class);
		accountImpl.createPost(1L, "bla bla bla");
		
		SocialAccount socialAccount = applicationContext.getBean("socialAccount", SocialAccount.class);
		socialAccount.createPost(1L, "bla bla bla");
		accountImpl = applicationContext.getBean("instagramAccount", AccountService.class);
		accountImpl.createPost(1L, "bla bla bla");
		
		accountImpl = applicationContext.getBean("whatsAppAccount", AccountService.class);
		accountImpl.createPost(1L, "bla bla bla");
		
		*/
		
		
		
		
		
		
		/*
		SocialAccount socialAccountFacebook = new SocialAccount(new FacebookAccountImpl());
		socialAccountFacebook.createAccount("eslam", "123");
		socialAccountFacebook.createPost(1L, "bla bla");
		
		SocialAccount socialAccountInsta = new SocialAccount(new InstagramAccountImpl());
		socialAccountInsta.createAccount("eslam", "123");
		socialAccountInsta.createPost(1L, "bla bla");
		*/
		
		
		
		
		
		
		
		
		/*AccountService facebookaccount = new FacebookAccountImpl();
		facebookaccount.createAccount("eslam", "123");
		facebookaccount.createPost(1L, "bla bla");
		
		AccountService instagrAccount = new InstagramAccountImpl();
		instagrAccount.createAccount("eslam", "123");
		instagrAccount.createPost(1L, "bla bla");
		
		AccountService whatsAppAccount = new WhatsAppAccountImpl();
		whatsAppAccount.createAccount("eslam", "123");
		whatsAppAccount.createPost(1L, "bla bla");*/
	}

}
