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
    
}


