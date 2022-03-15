package com.abc.factory;

import com.abc.dao.IStudentDao;
import com.abc.dao.StudentDaoImpl;

public class StudentDaoFactory {
	

	private static IStudentDao studentDaoImpl;

	static {
		studentDaoImpl = new StudentDaoImpl();
	}
	
	public static IStudentDao getDao() {
		return studentDaoImpl;
	}
}
