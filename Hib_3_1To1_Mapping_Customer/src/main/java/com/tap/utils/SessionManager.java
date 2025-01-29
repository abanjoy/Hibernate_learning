package com.tap.utils;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.hib.entity.Customer;
import com.hib.entity.Customer_Info;

public class SessionManager {
	
	public static Session getSession() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Customer_Info.class);
		return config.buildSessionFactory().openSession();
	}

}
