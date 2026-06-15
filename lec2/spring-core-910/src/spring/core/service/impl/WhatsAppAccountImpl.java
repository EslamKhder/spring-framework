package spring.core.service.impl;

import org.springframework.stereotype.Component;

@Component
public class WhatsAppAccountImpl  implements AccountService {
	
	@Override
	public void createAccount(String username, String password) {
		System.out.println("WhatsApp Account created with username: " + username + " and password: " + password);
	}
	
	@Override
	public void createPost(Long userd, String text) {
		System.out.println("WhatsApp post created with text : " + text + " with user id: " + userd);
	}
}
