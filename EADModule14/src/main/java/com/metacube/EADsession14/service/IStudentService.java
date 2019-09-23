package com.metacube.EADsession14.service;

import java.util.List;

import com.metacube.EADsession14.model.StudentInfo;

/**
 * Interface for base service.
 * @param <T>
 */
public interface IStudentService {

	public boolean checkUniqueEmail(String email);
	public List<StudentInfo> getAllStudents();
	public void addStudent(StudentInfo studentObj);
	
	
}
