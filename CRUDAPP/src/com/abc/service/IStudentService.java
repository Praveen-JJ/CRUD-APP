package com.abc.service;

import java.util.Set;

import com.abc.pojo.Student;

public interface IStudentService {
	public String save(Student student);

	public Student getStudentById(int id);

	public String updateStudent(Student student);

	public String deleteStudentById(int id);
	
	public Set<Student> displayTable();
}
