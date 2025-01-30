package com.tap.main;

import org.hibernate.Session;

import com.tap.entity.Product;
import com.tap.entity.ProductDetails;
import com.tap.util.SessionManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = new SessionManager().getSession();
		
		Product p =new Product("Chips", 0.250);
		ProductDetails pd = new ProductDetails("Karmur", 60, 5);
		
		p.setpDetails(pd);
		pd.setProduct(p);
		
		session.beginTransaction();
		session.persist(p);
		session.getTransaction().commit();
		System.out.println("Successfull");

	}

}
