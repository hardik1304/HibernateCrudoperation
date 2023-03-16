package com.service;

import java.util.List;

import com.dto.StudentDTO;

public interface IStudentService {

	public String addStudent(StudentDTO student);

	public String deleteStudent(int studentId);

	public StudentDTO getStudentInfo(int studentId);
	public String updateStudentInfo(int studentId);
	
	public List<StudentDTO> getAllStudentInfo();
}
