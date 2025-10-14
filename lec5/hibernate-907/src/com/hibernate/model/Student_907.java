package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Student_907_1")
public class Student_907 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "student_id")
	private Long id;
	
	@Column(name = "student_userName", unique = true, nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	private Integer age;
	
	private String address;

	
	public Student_907() {
		
	}
	
	public Student_907(String userName, String password, Integer age, String address) {
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.address = address;
	}
	public Student_907(Long id, String userName, String password, Integer age, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student_907 [id=" + id + ", userName=" + userName + ", password=" + password + ", age=" + age
				+ ", address=" + address + "]";
	}
	
	
}
