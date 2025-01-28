package com.tap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sid")
	private int sid;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="pincode")
	private  int pincode;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Student(int sid, String name, String email, String address, int pincode) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String email, String address, int pincode) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", email=" + email + ", address=" + address + ", pincode="
				+ pincode + "]";
	}
	
}
