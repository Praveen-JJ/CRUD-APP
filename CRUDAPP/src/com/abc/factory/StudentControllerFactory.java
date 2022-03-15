package com.abc.factory;

import com.abc.controller.IStudentController;
import com.abc.controller.StudentControllerImpl;

public class StudentControllerFactory {
	private static IStudentController studentControllerImpl;
	static {
		studentControllerImpl = new StudentControllerImpl();
	}
	
	public static IStudentController getController() {
		return studentControllerImpl;
	}
}
