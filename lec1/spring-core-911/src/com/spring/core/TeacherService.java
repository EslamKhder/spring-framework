package com.spring.core;

import org.springframework.stereotype.Component;

@Component("myTeacher")
public class TeacherService implements SchoolService {
	
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
