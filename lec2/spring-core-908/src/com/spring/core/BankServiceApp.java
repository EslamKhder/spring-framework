package com.spring.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class BankServiceApp  implements ApplicationService{
	
	private Boolean connection = false;
	
	@Value("${app.spring.core.name}")
	private String name;
	
    @Override
    public void startApp() {
    	if(connection) {
    		System.out.println("start app BankServiceApp");
    	} else {
    		System.out.println("no connection");
    	}
    }
    
    //@PostConstruct
    void openConnection() {
    	System.out.println("openConnection");
    	connection = true;
    }
    
    //@PreDestroy
    void closeConnection() {
    	System.out.println("closeConnection");
    	connection = false;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
