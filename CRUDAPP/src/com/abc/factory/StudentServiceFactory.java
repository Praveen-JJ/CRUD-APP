package com.abc.factory;

import com.abc.service.IStudentService;
import com.abc.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private static StudentServiceImpl studentServiceImpl;

	static {
		studentServiceImpl = new StudentServiceImpl();
	}
	
	public static IStudentService getService() {
		return studentServiceImpl;
	}
}
