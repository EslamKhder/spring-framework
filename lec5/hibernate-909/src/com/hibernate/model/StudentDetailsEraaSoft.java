package com.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class StudentDetailsEraaSoft {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String address;
	
	private String phoneNumber;
	
	@OneToOne
	@JoinColumn(name = "Student_Eraa_Soft_id", unique = true)
	private StudentEraaSoft studentEraaSoft;
	

	public StudentDetailsEraaSoft() {
		
	}
	
	public StudentDetailsEraaSoft(Integer id, String address, String phoneNumber) {
		super();
		this.id = id;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public StudentDetailsEraaSoft(String address, String phoneNumber) {
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public StudentEraaSoft getStudentEraaSoft() {
		return studentEraaSoft;
	}

	public void setStudentEraaSoft(StudentEraaSoft studentEraaSoft) {
		this.studentEraaSoft = studentEraaSoft;
	}
	
	
}
