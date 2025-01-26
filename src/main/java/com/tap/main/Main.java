package com.tap.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.Entity.Employee;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Configuration config = new Configuration();
//		Configuration config1 = config.configure();
//		Configuration config2 = config1.addAnnotatedClass(Employee.class);
//		
//		System.out.println(config);
//		System.out.println(config1);
//		System.out.println(config2);
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
		System.out.println(config);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		
		System.out.println(session);
		
		Transaction t = session.beginTransaction();
		
		Employee e = new Employee(1,"Alex","proffesor",200000);
		
		session.save(e);
		
		t.commit();
		System.out.println("Data is inserted");
		
		
	}

}
