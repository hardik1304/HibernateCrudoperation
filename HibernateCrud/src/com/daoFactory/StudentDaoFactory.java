package com.daoFactory;

import com.dao.IStudentDao;
import com.dao.StudentDaoImplementation;

public class StudentDaoFactory {

	private StudentDaoFactory() {

	}

	public static IStudentDao dao = null;

	public static IStudentDao getStudentDao() {
		if (dao == null) {
			dao = new StudentDaoImplementation();
		}
		return dao;
	}

}
