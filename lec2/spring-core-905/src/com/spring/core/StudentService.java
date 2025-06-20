package com.spring.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("student")
public class StudentService implements SchoolService {
	
	private boolean connection = false;
    
	@Value("${app.name}")
	private String name;
	
	@Override
    public void printData() {
    	if (connection) {
    		System.out.println("hi Student");
    	} else {
    		System.out.println("no connection");
    	}       
    }
	
	@PostConstruct
	void openConnection(){
		System.out.println("open connection");
		connection = true;
	}
	
	@PreDestroy
	void closeConnection(){
		System.out.println("close connection");
		connection = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
