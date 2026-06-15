package spring.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SocialAccount {

	//@Autowired
	private /*@Qualifier("whatsAppAccountImpl")*/ AccountService accountService;
	
	@Autowired
	public SocialAccount(@Qualifier("whatsAppAccountImpl") AccountService accountService) {
		this.accountService = accountService;
	}


	public void createAccount(String username, String password) {
		accountService.createAccount(username, password);
	}
	
	
	/*public AccountService getAccountService() {
		return accountService;
	}

	
	@Autowired
	public void setAccountService(@Qualifier("instagramAccountImpl") AccountService accountService) {
		this.accountService = accountService;
	}*/


	public void createPost(Long userd, String text) {
		accountService.createPost(userd, text);
	}
}
