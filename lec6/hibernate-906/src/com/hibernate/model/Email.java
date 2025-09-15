package com.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String email;
	
	
	
	@ManyToOne
	@JoinColumn(name = "student_group_id")
	private StudentGroup906 studentGroup906;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentGroup906 getStudentGroup906() {
		return studentGroup906;
	}

	public void setStudentGroup906(StudentGroup906 studentGroup906) {
		this.studentGroup906 = studentGroup906;
	}
	
	
}
