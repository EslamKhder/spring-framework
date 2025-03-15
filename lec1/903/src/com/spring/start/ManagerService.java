package com.spring.start;

import org.springframework.stereotype.Component;

//@Component
public class ManagerService implements UserService {

	@Override
	public void saveUser(String user) {
		// TODO Auto-generated method stub
		System.out.println("save user with name " + user + " on ManagerService");
	}

}