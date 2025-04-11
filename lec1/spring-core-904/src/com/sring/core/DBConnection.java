package com.sring.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("dBConnection")
//@Scope("prototype")
public class DBConnection {/* dBConnection dbConnection dbconnection*/

	
	private Boolean connection = false;
	
	@Value("${app_service-name}")
	private String name;
	
	void print() {
		if (connection == true) {
			System.out.println("your name is  " + name);
		} else {
			System.out.println("invalid connection");
		}
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@PostConstruct
	void openCon() {
		connection = true;
	}
	
	@PreDestroy
	void closeCon() {
		connection = false;
	}
	
	
	
	
	
	
	
	
	
}
