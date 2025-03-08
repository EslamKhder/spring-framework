package com.spring.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClentServiceImpl2 {

	private UserService userService;
	
	@Autowired
	public ClentServiceImpl2(@Qualifier("clientService") UserService userService) { // setUserService   UserService  userService
		this.userService = userService;
	}

	void save(String name) {
		userService.saveUser(name);
	}
}
