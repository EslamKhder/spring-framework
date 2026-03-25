package com.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmailEraaSoft {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "Student_Eraa_Soft_ID")
	private StudentEraaSoft studentEraaSoft;

	public EmailEraaSoft() {
		
	}
	
	public EmailEraaSoft(String email) {
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentEraaSoft getStudentEraaSoft() {
		return studentEraaSoft;
	}

	public void setStudentEraaSoft(StudentEraaSoft studentEraaSoft) {
		this.studentEraaSoft = studentEraaSoft;
	}
	

}
