package com.spring.start;

import org.springframework.stereotype.Component;

@Component
public class ClientService implements UserService {

	private boolean connection = false;
	
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void saveUser(String user) {
		// TODO Auto-generated method stub
		if (connection) {
			System.out.println("save user with name " + user + " on ClientService");
		} else {
			System.out.println("no connection");
		}
		
	}

	void start() {
		connection = true;
		System.out.println("start method");
	}
	
	void end() {
		connection = false;
		System.out.println("end method");
	}
}