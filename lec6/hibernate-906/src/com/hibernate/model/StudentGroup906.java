package com.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class StudentGroup906 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String userName;
	
    private int password;
    
    @OneToOne(mappedBy = "studentGroup906")
    private StudentGroupDetails906 studentGroupDetails907;
    
    @OneToMany(mappedBy = "studentGroup906")
    private List<Email> emails;
    
    @ManyToMany(mappedBy = "studentGroup906")
    private List<Course906> courses;

    public StudentGroup906() {
    	
    }
    
	public StudentGroup906(String userName, int password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public StudentGroupDetails906 getStudentGroupDetails907() {
		return studentGroupDetails907;
	}

	public void setStudentGroupDetails907(StudentGroupDetails906 studentGroupDetails907) {
		this.studentGroupDetails907 = studentGroupDetails907;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Course906> getCourses() {
		return courses;
	}

	public void setCourses(List<Course906> courses) {
		this.courses = courses;
	}
    
    
}


