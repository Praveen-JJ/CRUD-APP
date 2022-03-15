package com.abc.service;

import java.util.Set;

import com.abc.dao.IStudentDao;
import com.abc.factory.StudentDaoFactory;
import com.abc.pojo.Student;

public class StudentServiceImpl implements IStudentService {

	@Override
	public String save(Student student) {
		
		IStudentDao studentDao = StudentDaoFactory.getDao();
		
		return studentDao.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		
		IStudentDao studentDao = StudentDaoFactory.getDao();
		
		return studentDao.getStudentById(id);
	}

	@Override
	public String updateStudent(Student student) {
		
		IStudentDao studentDao = StudentDaoFactory.getDao();
		
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudentById(int id) {
		
		IStudentDao studentDao = StudentDaoFactory.getDao();
		
		return studentDao.deleteStudentById(id);
	}

	@Override
	public Set<Student> displayTable() {

		IStudentDao studentDao = StudentDaoFactory.getDao();
		
		return studentDao.displayTable();
	}

}
