package com.hibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Course906 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String course;
	
	@ManyToMany
	@JoinTable(
	    name="Stu_COR",
	    joinColumns = @JoinColumn(name="cor_id"),        
	    inverseJoinColumns = @JoinColumn(name="stud_id")
	)
	private List<StudentGroup906> studentGroup906;
}
