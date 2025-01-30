package com.tap.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productDetails")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pdid")
	private int pdId;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name="price")
	private double price;
	@Column(name="sino")
	private int slNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productId",referencedColumnName = "pid")
	private Product product;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getPdId() {
		return pdId;
	}
	public void setPdId(int pdId) {
		this.pdId = pdId;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSlNo() {
		return slNo;
	}
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}
	public ProductDetails(int pdId, String manufacturer, double price, int slNo) {
		super();
		this.pdId = pdId;
		this.manufacturer = manufacturer;
		this.price = price;
		this.slNo = slNo;
	}
	public ProductDetails(String manufacturer, double price, int slNo) {
		super();
		this.manufacturer = manufacturer;
		this.price = price;
		this.slNo = slNo;
	}
	public ProductDetails() {
		super();
	}
	
	

}
