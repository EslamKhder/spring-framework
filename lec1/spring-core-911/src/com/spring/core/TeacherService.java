package com.spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
@Component
@Scope("prototype")
public class TeacherService implements SchoolService {
	
	@Value("${teacher.service.name}")
	private String name;
	
    @Override
    public void startApp() {
        System.out.println("startApp Teacher");
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
