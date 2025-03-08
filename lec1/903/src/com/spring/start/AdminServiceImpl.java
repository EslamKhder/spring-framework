package com.spring.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl {

	private UserService userService;
	
	@Autowired
	public AdminServiceImpl(@Qualifier("adminService") UserService userService) { // setUserService   UserService  userService
		this.userService = userService;
	}

	void save(String name) {
		userService.saveUser(name);
	}
}
