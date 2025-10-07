package com.spring.core;

public class BankSystem implements BaseSystem {
	
	private String name;
	
	private Boolean connection = false;
	
	
	void saveStudent(String name) {
		if (connection) {
			System.out.println("studnet saved with name : " + name);
		} else {
			System.out.println("no connection");
		}
	}
    @Override
    public void startSystem() {
        System.out.println("BankSystem Start.........");

    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	void start() {
		System.out.println("start......");
		connection = true;
	}
	
	void end() {
		System.out.println("end......");
		connection = false;
	}

    
}
