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

//Product Entity: 
 //id (Primary Key, auto-generated) 
 //name (Not Null) 
 //price (Decimal, Not Null) 
 //stockQuantity (Integer) 
 //Relationship: Many-to-One with Category 
@Entity
@Table(name="product")
public class Product {
	@ManyToOne
	@JoinColumn(name = "category_id")
    private Category category;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name",length=30, nullable=false)
	private String name;
	@Column(name="price",nullable=false)
	private BigDecimal price;
	@Column(name = "stock_quantity") 
	private int stockQuantity;
	public Product() {
		this.id=0;
		this.name=null;
		this.price=null;
		this.stockQuantity=0;
		
	}
	public Product(Category category, String name, BigDecimal price, int stockQuantity) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	@Override
	public String toString() {
		return "Product [category=" + category + ", id=" + id + ", name=" + name + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + "]";
	}
	

}
