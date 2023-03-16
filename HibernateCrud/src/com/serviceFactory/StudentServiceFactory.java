package com.serviceFactory;

import com.service.IStudentService;
import com.service.StudentServiceImplementation;

public class StudentServiceFactory {

	private StudentServiceFactory() {

	}

	private static IStudentService service = null;

	public static IStudentService getStudentService() {
		if (service == null) {

			service = new StudentServiceImplementation();
		}
		return service;

	}

}
