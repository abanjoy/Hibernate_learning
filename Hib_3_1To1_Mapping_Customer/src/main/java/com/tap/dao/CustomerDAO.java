package com.tap.dao;

import java.util.List;

import com.hib.entity.Customer;

public interface CustomerDAO {
	
	public void insertCustomer(Customer c);
	public List<Customer> fetchAllCustomer();
	public Customer fetchSpecific_Email(String email);
	public Customer fetchSpecific(int cid);
	public void updateCustomer(long mobile,String email);
	public void deleteCustomer(int cid);

}
