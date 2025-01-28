package com.tap.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.Student;
import com.tap.entity.StudentDetails;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetails.class);
		
		Session session = config.buildSessionFactory().openSession();
		
		session.beginTransaction();
		 Student s= new Student( "Alan", "alan@gmail.com");
		 StudentDetails sd =new StudentDetails(9089786534L,"Alapuzha",588623);
		 
		 s.setStudentDetails(sd);
		 
		 session.persist(s);
		 
		 session.getTransaction().commit();
		 

	}

}
