package com.hib.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_info")
public class Customer_Info {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ciid")
	private int ciid;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="amount")
	private double amount;
	public int getCiid() {
		return ciid;
	}
	public void setCiid(int ciid) {
		this.ciid = ciid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Customer_Info(int ciid, String email, String address, double amount) {
		super();
		this.ciid = ciid;
		this.email = email;
		this.address = address;
		this.amount = amount;
	}
	public Customer_Info(String email, String address, double amount) {
		super();
		this.email = email;
		this.address = address;
		this.amount = amount;
	}
	public Customer_Info() {
		super();
	}
	@Override
	public String toString() {
		return "Customer_Info [ciid=" + ciid + ", email=" + email + ", address=" + address + ", amount=" + amount + "]";
	}
	
	

}
