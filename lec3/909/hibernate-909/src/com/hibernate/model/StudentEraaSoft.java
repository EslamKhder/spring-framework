package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Eraa_Soft")
public class StudentEraaSoft {
	
	@Id
	@Column(name = "student_id")
	private Integer id;
	
	@Column(name = "student_userName", unique = true, nullable = false)
	private String userName;
	
	@Column(name = "student_password")
	private String password;

	@Column(name = "student_address")
	private String address;
	
	public StudentEraaSoft() {
		
	}
	public StudentEraaSoft(Integer id, String userName, String password, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "id: " + id + " username : " + userName + " password: " + password + " address: " + address;
	}
	
	

}
