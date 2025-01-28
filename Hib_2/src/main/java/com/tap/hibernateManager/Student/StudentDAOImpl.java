package com.tap.hibernateManager.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tap.entity.Student;

public class StudentDAOImpl implements StudentDAO {
	private Session session;
	private Transaction t;

	{
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		session = config.buildSessionFactory().openSession();
		
		
	}

	@Override
	public void inserStudent(Student s) {
		// TODO Auto-generated method stub
		t = session.beginTransaction();
		session.persist(s);
		t.commit();
		
		System.out.println("Insertion of student is successful");
		session.close();
		
	}

	@Override
	public void fetchAll() {
		// TODO Auto-generated method stub
		Query q = session.createQuery("from Student");
		List<Student> list = q.list();
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

	@Override
	public void fetchOne(int sid) {
		// TODO Auto-generated method stub
		Student s = session.get(Student.class, sid);
		System.out.println(s);

	}
	
	public Student fetchStudent(int sid) {
		// TODO Auto-generated method stub
		Student s = session.get(Student.class, sid);
//		System.out.println(s);
		return s;

	}

	@Override
	public void fetchByname(String Sname) {
		// TODO Auto-generated method stub
		Query q = session.createQuery("from Student where name = :name").setParameter( "name",Sname);
		
		System.out.println(q.list().get(0));
	}

	@Override
	public void deleteStudent(int sid) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		
		Student s = fetchStudent(sid);
		try {
			session.delete(s);
			session.getTransaction().commit();
			System.out.println("Delete Successfull");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(s);
		
		
	}

	@Override
	public void updateStudent(String email,int sid) {
		// TODO Auto-generated method stub
		Student s = session.get(Student.class, sid);
		if(s != null) {
			s.setEmail(email);
			session.beginTransaction();
			session.persist(s);
			session.getTransaction().commit();
			System.out.println("Successfull");
			
		}
		
	}

}
