package com.spring.core;

public class EmployeeService implements SchoolService {
	private Boolean connection = false;
    @Override
    public void startApp() {
        System.out.println("startApp Employee");
    }
    
    public void connectToDb() {
    	System.out.println("connected success");
    	connection = true;
    }

    public void closeConnection() {
    	System.out.println("connected closed");
    	connection = false;
    }
	public Boolean getConnection() {
		return connection;
	}

    
    
}
