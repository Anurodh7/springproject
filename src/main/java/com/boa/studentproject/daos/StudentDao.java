package com.boa.studentproject.daos;

import java.util.List;

import com.boa.studentproject.models.Student;

public interface StudentDao {
	
	public void addStudent (Student s);
	public void deleteStudent (int id);
	public void updateStudent(Student s);
	public Student getById (int id);
	public List<Student> getAllStudent ();
	
	

}
