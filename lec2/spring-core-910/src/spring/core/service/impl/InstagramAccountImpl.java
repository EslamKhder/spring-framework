package spring.core.service.impl;

import org.springframework.stereotype.Component;

@Component
public class InstagramAccountImpl  implements AccountService {

	private String name;
	
	
	@Override
	public void createAccount(String username, String password) {
		System.out.println("Instagram Account created with username: " + username + " and password: " + password);
	}
	
	@Override
	public void createPost(Long userd, String text) {
		System.out.println("Instagram post created with text : " + text + " with user id: " + userd);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void start() {
		System.out.println("start bean init ......");
	}
	

	
	public void end() {
		System.out.println("end bean ......");
	}
}
