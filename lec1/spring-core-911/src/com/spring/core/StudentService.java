package com.spring.core;

public class StudentService implements SchoolService {
	
	private Boolean connection = false;
	
	public void openConnection() {
		System.out.println("start open connection.....");
		connection = true;
		System.out.println("connection success.....");
	}
	
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
