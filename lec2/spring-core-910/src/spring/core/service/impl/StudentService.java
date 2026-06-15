package spring.core.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Student")
//@Scope("prototype")
public class StudentService {

	private boolean connection = false;
	
	public void getStudentData() {
		if (connection) {
			System.out.println("i am eslam");
		} else {
			System.out.println("no connection found");
		}
	}
	
	
	@PostConstruct
	public void openConnection() {
		System.out.println("connection will open");
		connection = true;
	}
	
	@PreDestroy
	public void closeConnection() {
		System.out.println("connection will close");
		connection = false;
	}
}
