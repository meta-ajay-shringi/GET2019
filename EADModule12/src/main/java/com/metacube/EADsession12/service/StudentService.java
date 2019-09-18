package com.metacube.EADsession12.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADsession12.model.StudentInfo;
import com.metacube.EADsession12.repository.StudentRepository;

/**
 * Student service class.
 */
@Service
public class StudentService implements BaseService<StudentInfo> {

	@Autowired
	private StudentRepository repository;

	@Override
	public StudentInfo getById(int id) {
		return null;
	}

	@Override
	public List<StudentInfo> getAll() {

		return repository.findAll();
	}

	@Override
	public void add(StudentInfo studentObj) {
		repository.save(studentObj);
	}

	public boolean checkUniqueEmail(String email) {

		boolean flag = false;
		List<StudentInfo> studentList = new ArrayList<>();
		studentList = repository.findByemailContainingIgnoreCase(email);

		if (studentList.size() == 0)
			flag = true;

		return flag;
	}

	@Override
	public void delete(StudentInfo t) {
		
	}

	@Override
	public void update(StudentInfo t, String[] param) {
		
	}

}
