package com.spring.core;

public class StudentService implements SchoolService {
	
	private boolean connection = false;
    
	@Override
    public void printData() {
    	if (connection) {
    		System.out.println("hi Student");
    	} else {
    		System.out.println("no connection");
    	}       
    }
	
	void openConnection(){
		System.out.println("open connection");
		connection = true;
	}
	
	void closeConnection(){
		System.out.println("close connection");
		connection = false;
	}
}
