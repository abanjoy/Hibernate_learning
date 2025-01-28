package com.tap.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.Student;
import com.tap.hibernateManager.Student.StudentDAO;
import com.tap.hibernateManager.Student.StudentDAOImpl;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s = new Student("Dano","dano@gmail.com","Alapuzha",588634);
		
		StudentDAO sdao = new StudentDAOImpl();
//		sdao.inserStudent(s);
//		sdao.fetchAll();
//		sdao.fetchOne(52);
//		sdao.fetchByname("Jinson");
//		sdao.deleteStudent(52);
		sdao.updateStudent("jinson123@gmail.com", 2);

	}

}
