package com.abc.controller;

import java.util.Set;

import com.abc.factory.StudentServiceFactory;
import com.abc.pojo.Student;
import com.abc.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	@Override
	public String save(Student student) {
		
		IStudentService studentService = StudentServiceFactory.getService();

		return studentService.save(student);
	}


	@Override
	public Student getStudentById(int id) {
		
		IStudentService studentService = StudentServiceFactory.getService();
		
		return studentService.getStudentById(id);
	}

	@Override
	public String updateStudent(Student student) {
		
		IStudentService studentService = StudentServiceFactory.getService();
		return studentService.updateStudent(student);
	}

	@Override
	public String deleteStudentById(int id) {
		
		IStudentService studentService = StudentServiceFactory.getService();
		
		return studentService.deleteStudentById(id);
	}
	
	@Override
	public Set<Student> displayTable() {
		
		IStudentService studentService = StudentServiceFactory.getService();
		
		return studentService.displayTable();
	}

}
