package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    
    @OneToOne
    @JoinColumn(name = "ref_id", nullable = false, unique = true)
    private StudentGroup906 studentGroup906;
    
}


