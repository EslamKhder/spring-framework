package com.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class StudentGroupDetails906 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    private int age;
    
    private String address;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_group_id", nullable = false, unique = true)
    private StudentGroup906 studentGroup906;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public StudentGroup906 getStudentGroup906() {
		return studentGroup906;
	}

	public void setStudentGroup906(StudentGroup906 studentGroup906) {
		this.studentGroup906 = studentGroup906;
	}

	public StudentGroupDetails906() {
		super();
	}

	public StudentGroupDetails906(int age, String address) {
		super();
		this.age = age;
		this.address = address;
	}
    
    
    
}


