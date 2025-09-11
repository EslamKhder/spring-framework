package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "ref_id", nullable = false)
	private StudentGroup906 studentGroup906;
}
