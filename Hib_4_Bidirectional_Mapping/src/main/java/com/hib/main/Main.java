package com.hib.main;

import java.util.List;

import org.hibernate.Session;

import com.hib.entity.Customer;
import com.hib.entity.Customer_Info;
import com.tap.dao.CustomerDAO;
import com.tap.daoImpl.CustomerDAOImpl;
import com.tap.utils.SessionManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Session session = new SessionManager().getSession();
		CustomerDAO cdao = new CustomerDAOImpl();
//		Customer c = new Customer("Prakash", 9685471447L);
//		Customer_Info ci = new Customer_Info("prakash@gmail.com", "Malappuram", 2400.00);
//		c.setCustomerInfo(ci);
//		cdao.insertCustomer(c);
		
//		List sl = cdao.fetchAllCustomer();
//		
//		for(int i=0;i<sl.size();i++) {
//			System.out.println(sl.get(i));
//		}
		
//		System.out.println(cdao.fetchSpecific_Email("prakash@gmail.com"));
//		System.out.println(cdao.fetchSpecific(1));
		
//		cdao.updateCustomer(9685471447L, "praksah123@gmail.com");
		
//		cdao.deleteCustomer(1);
		
		Customer c = new Customer("naveen",9358471425L);
		Customer_Info ci = new Customer_Info("naveen@gmail.com","calicut",900.00);
		
		ci.setCustomer(c);
		c.setCustomerInfo(ci);
		Session session = new SessionManager().getSession();
		
		session.beginTransaction();
		
		session.persist(ci);
		
		session.getTransaction().commit();
		System.out.println("Successfull");
//		cdao.insertCustomer(ci);
		

	}

}
