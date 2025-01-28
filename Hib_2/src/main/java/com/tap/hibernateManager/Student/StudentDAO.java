package com.tap.hibernateManager.Student;

import com.tap.entity.Student;

public interface StudentDAO {
	
	void inserStudent(Student s);
	
	void fetchAll();
	
	void fetchOne(int sid);
	
	void fetchByname(String name);
	
	void deleteStudent(int sid);

	void updateStudent(String email,int sid);
}
