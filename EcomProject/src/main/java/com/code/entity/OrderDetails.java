package com.code.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//OrderDetails Entity: 
//o id (Primary Key, auto-generated) 
//o quantity (Integer, Not Null) 
//o unitPrice (Decimal, Not Null) 
//o Relationship: Many-to-One with Orders, Many-to-One with Product 
@Entity
@Table(name="orderDetails")

public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="quantity", nullable=false)
	private int quantity;
	@Column(name="unitPrice",nullable=false)
	private BigDecimal unitPrice;
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Orders orders;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	public OrderDetails() {
		this.id=0;
		this.quantity=0;
		this.unitPrice=null;
		
	}
	public OrderDetails(int quantity, BigDecimal unitPrice, Orders orders, Product product) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.orders = orders;
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", orders=" + orders
				+ ", product=" + product + "]";
	}
	
	
}
