package com.metacube.EADsession14.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADsession14.model.StudentInfo;
import com.metacube.EADsession14.repository.StudentRepository;

/**
 * Student service class.
 */
@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public List<StudentInfo> getAllStudents() {

		return repository.findAll();
	}

	@Override
	public void addStudent(StudentInfo studentObj) {
		
		repository.save(studentObj);
	}

	@Override
	public boolean checkUniqueEmail(String email) {

		boolean flag = false;
		List<StudentInfo> studentList = new ArrayList<>();
		studentList = repository.findByemailContainingIgnoreCase(email);

		if (studentList.size() == 0)
			flag = true;

		return flag;
	}

}
