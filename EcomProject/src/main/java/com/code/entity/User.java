package com.code.entity;
//id (Primary Key, auto-generated) 
//o username (Unique, Not Null) 
//o password (Hashed, Not Null) 
//o email (Unique, Not Null) 
//o role (ADMIN, CUSTOMER) 
//o Relationship: One-to-Many with Orders


import java.util.ArrayList;
import java.util.List;


import com.code.entity.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="emailId",nullable=false, unique=true)
	private String emailId;
	@Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<Orders> orders;
	public User() {
		this.id=0;
		this.username=null;
		this.password=null;
		this.emailId=null;
		this.role=null;
	}
	public User(String username, String password, String emailId, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.role = role;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
//	public List<Orders> getOrders() {
//		return orders;
//	}
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", emailId=" + emailId
				+ ", role=" + role + "]";
	}
	
	 
	
}
