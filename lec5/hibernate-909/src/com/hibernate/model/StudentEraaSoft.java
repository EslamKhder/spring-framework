package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class StudentEraaSoft {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String userName;
	
	private String password;
	
	@ManyToMany
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(name= "Student_id"),
			inverseJoinColumns = @JoinColumn(name= "Course_id")
	)
	private List<CourseEraaSoft> courseEraaSofts = new ArrayList<CourseEraaSoft>();
	
	/*@OneToMany(mappedBy = "studentEraaSoft", cascade = CascadeType.PERSIST)
	private List<EmailEraaSoft> emailEraaSofts = new ArrayList<EmailEraaSoft>();
*/
	/*
	@OneToOne(mappedBy = "studentEraaSoft", cascade = CascadeType.PERSIST)
	private StudentDetailsEraaSoft studentDetailsEraaSoft;
	*/
	public StudentEraaSoft() {
		
	}
	public StudentEraaSoft(Integer id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	
	public StudentEraaSoft(String userName, String password) {
		this.userName = userName;
		this.password = password;
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
	
	/*public List<EmailEraaSoft> getEmailEraaSofts() {
		return emailEraaSofts;
	}
	public void setEmailEraaSofts(List<EmailEraaSoft> emailEraaSofts) {
		this.emailEraaSofts = emailEraaSofts;
		emailEraaSofts.stream().forEach(email -> email.setStudentEraaSoft(this));
	}
	*/
	
	/*
	public StudentDetailsEraaSoft getStudentDetailsEraaSoft() {
		return studentDetailsEraaSoft;
	}
	
	// studentEraaSoft.setStudentDetailsEraaSoft(studentDetailsEraaSoft);
	public void setStudentDetailsEraaSoft(StudentDetailsEraaSoft studentDetailsEraaSoft) {
		this.studentDetailsEraaSoft = studentDetailsEraaSoft;
		studentDetailsEraaSoft.setStudentEraaSoft(this);
	}
	@Override
	public String toString() {
		return "id: " + id + " username : " + userName + " password: " + password;
	}
	
	*/

}
