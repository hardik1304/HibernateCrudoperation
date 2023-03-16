package com.dao;

import java.util.List;

import com.dto.StudentDTO;

public interface IStudentDao {

	public String addStudent(StudentDTO student);

	public StudentDTO getStudentInfo(int studentId);

	public String deleteStudent(int studentId);

	public String updateStudentInfo(int studentId);
	public List<StudentDTO> getAllStudentInfo();
}
