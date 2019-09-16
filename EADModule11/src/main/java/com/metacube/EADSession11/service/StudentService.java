package com.metacube.EADSession11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSession11.dao.student.IStudent;
import com.metacube.EADSession11.dao.student.StudentDao;
import com.metacube.EADSession11.model.StudentInfo;
/**
 * Student service class.
 */
@Service
public class StudentService implements BaseService<StudentInfo> {
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public StudentInfo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentInfo> getAll() {
		
		return studentDao.getAll();
	}

	@Override
	public void add(StudentInfo studentObj) {	
		studentDao.add(studentObj);
	}

	@Override
	public void delete(StudentInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StudentInfo t, String[] param) {
		// TODO Auto-generated method stub
		
	}

}
