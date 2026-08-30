package com.hibernate.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String orderNumber;
	
	private Double totalPrice;

	@ManyToOne
	@JoinColumn
	private User user;

	public Orders() {
		
	}
	public Orders(Long id, String orderNumber, Double totalPrice) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
	}
	
	public Orders(String orderNumber, Double totalPrice) {
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
	}

	public Orders(Long id, String orderNumber, Double totalPrice, User user) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
		this.user = user;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
