package com.abc.controller;

import java.util.Set;

import com.abc.pojo.Student;

public interface IStudentController {
	public String save(Student student);

	public Student getStudentById(int id);

	public String updateStudent(Student student);

	public String deleteStudentById(int id);
	
	public Set<Student> displayTable();
}
