package com.spring.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
 
@Component
public class StudentService implements SchoolService {
	
	private Boolean connection = false;
	
	//@PostConstruct
	public void openConnection() {
		System.out.println("start open connection.....");
		connection = true;
		System.out.println("connection success.....");
	}
	
	//@PreDestroy
	public void closeConnection() {
		System.out.println("start close connection.....");
		connection = false;
		System.out.println("closed success.....");
	}
	
	public void getDatafromDb() {
		if (connection == true) {
			System.out.println("data get from db success.....");
		} else {
			System.out.println("no connection found .....");
		}
	}
    @Override
    public void startApp() {
        System.out.println("startApp student");
    }
}
