package com.code.entity;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//Orders Entity: 
//o id (Primary Key, auto-generated) 
//o orderDate (Timestamp, Not Null) 
//o totalAmount (Decimal, Not Null) 
//o Relationship: Many-to-One with Users, One-to-Many with OrderDetails
@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="orderDate",nullable=false)
	private LocalDateTime orderDate;
	@Column(name="totalAmount", nullable=false)
	private double totalAmount;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	public Orders(){
		this.id=0;
		this.orderDate=null;
		this.totalAmount=0;
		
	}
	public Orders(LocalDateTime date, double d, User user) {
		super();
		this.orderDate = date;
		this.totalAmount = d;
		this.user = user;
	}
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails = new ArrayList<>();

	public List<OrderDetails> getOrderDetails() {
	    return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
	    this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", user=" + user
				+ "]";
	}
	

}
