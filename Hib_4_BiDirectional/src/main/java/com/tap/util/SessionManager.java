package com.tap.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tap.entity.Product;
import com.tap.entity.ProductDetails;

public class SessionManager {
	Session session;
	{
		session = new Configuration().configure()
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(ProductDetails.class)
				.buildSessionFactory()
				.openSession();
	}
	
	public Session getSession() {
		return session;
	}

}
