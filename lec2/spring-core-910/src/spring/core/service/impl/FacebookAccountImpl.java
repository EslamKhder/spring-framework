package spring.core.service.impl;

import org.springframework.stereotype.Component;

// facebookAccountImpl
@Component
public class FacebookAccountImpl implements AccountService{

	@Override
	public void createAccount(String username, String password) {
		System.out.println("Facebook Account created with username: " + username + " and password: " + password);
	}
	
	@Override
	public void createPost(Long userd, String text) {
		System.out.println("Facebook post created with text : " + text + " with user id: " + userd);
	}
}
