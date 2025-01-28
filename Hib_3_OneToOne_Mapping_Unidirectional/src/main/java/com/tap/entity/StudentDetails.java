package com.tap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studentdetails")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sdid")
	private int sdId;
	@Column(name="mobile")
	private long mobile;
	@Column(name="address")
	private String address;
	@Column(name="pincode")
	private int pincode;
	
	public StudentDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSdId() {
		return sdId;
	}
	public void setSdId(int sdId) {
		this.sdId = sdId;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
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
	public StudentDetails( long mobile, String address, int pincode) {
		super();
//		this.sdId = sdId;
		this.mobile = mobile;
		this.address = address;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "StudentDetails [sdId=" + sdId + ", mobile=" + mobile + ", address=" + address + ", pincode=" + pincode
				+ "]";
	}
	
	
	
}
