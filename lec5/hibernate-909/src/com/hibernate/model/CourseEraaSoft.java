package com.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CourseEraaSoft {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String courseName;
	
	@ManyToMany(mappedBy = "courseEraaSofts")
	private List<StudentEraaSoft> studentEraaSofts = new ArrayList<StudentEraaSoft>();

	public CourseEraaSoft() {
		
	}
	
	public CourseEraaSoft(String courseName) {
		this.courseName = courseName;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<StudentEraaSoft> getStudentEraaSofts() {
		return studentEraaSofts;
	}

	public void setStudentEraaSofts(List<StudentEraaSoft> studentEraaSofts) {
		this.studentEraaSofts = studentEraaSofts;
	}

	
	
	
}
