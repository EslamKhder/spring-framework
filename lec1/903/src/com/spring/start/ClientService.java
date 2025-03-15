package com.spring.start;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("client")
public class ClientService implements UserService {

	private boolean connection = false;
	
	@Value("${app.user.name}")
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

	/*@PostConstruct
	void start() {
		connection = true;
		System.out.println("start method");
	}
	
	@PreDestroy
	void end() {
		connection = false;
		System.out.println("end method");
	}*/
}