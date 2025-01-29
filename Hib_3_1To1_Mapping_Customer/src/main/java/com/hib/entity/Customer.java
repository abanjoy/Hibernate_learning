package com.hib.entity;

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
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cid")
	private int cid;
	@Column(name="name")
	private String name;
	@Column(name="mobile")
	private Long mobile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerInfo")
	private Customer_Info customerInfo;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public Customer(int cid, String name, Long mobile) {
		super();
		this.cid = cid;
		this.name = name;
		this.mobile = mobile;
	}
	public Customer() {
		super();
	}
	public Customer(String name, Long mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	public Customer_Info getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(Customer_Info customerInfo) {
		this.customerInfo = customerInfo;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", mobile=" + mobile + ", customerInfo=" + customerInfo
				+ "]";
	}
	
	

}
