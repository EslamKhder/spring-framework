package com.spring.core;

public class StudentServiceSystem implements SchoolServiceSystem {

	private String serviceName;
	
    public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
    public void startApp() {
        System.out.println("start Student System");
    }
}
