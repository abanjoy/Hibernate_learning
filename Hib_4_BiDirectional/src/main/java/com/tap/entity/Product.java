package com.tap.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pid")
	private int pid;
	@Column(name="name")
	private String name;
	@Column(name="weight")
	private double weight;
	
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
	private ProductDetails pDetails;
	
	
	
	public ProductDetails getpDetails() {
		return pDetails;
	}
	public void setpDetails(ProductDetails pDetails) {
		this.pDetails = pDetails;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Product(int pid, String name, double weight) {
		super();
		this.pid = pid;
		this.name = name;
		this.weight = weight;
	}
	public Product(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	public Product() {
		super();
	}
	
	

}
