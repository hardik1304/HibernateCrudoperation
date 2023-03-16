package com.service;

import java.util.List;

import com.dao.IStudentDao;
import com.daoFactory.StudentDaoFactory;
import com.dto.StudentDTO;

public class StudentServiceImplementation implements IStudentService {

	private IStudentDao dao;

	@Override
	public String addStudent(StudentDTO student) {

		dao = StudentDaoFactory.getStudentDao();
		return dao.addStudent(student);
	}

	@Override
	public String deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		dao = StudentDaoFactory.getStudentDao();

		return dao.deleteStudent(studentId);
	}

	@Override
	public StudentDTO getStudentInfo(int studentId) {
		dao = StudentDaoFactory.getStudentDao();

		return dao.getStudentInfo(studentId);
	}

	public String updateStudentInfo(int studentId) {
		dao = StudentDaoFactory.getStudentDao();

		return dao.updateStudentInfo(studentId);
	}

	@Override
	public List<StudentDTO> getAllStudentInfo() {
		dao = StudentDaoFactory.getStudentDao();

		return dao.getAllStudentInfo();
	}
}
