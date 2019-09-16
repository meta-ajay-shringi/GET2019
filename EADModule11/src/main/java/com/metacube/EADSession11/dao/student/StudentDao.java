package com.metacube.EADSession11.dao.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;



import com.metacube.EADSession11.model.StudentInfo;

@Transactional
@Component
public class StudentDao implements IStudent{

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Override
	public StudentInfo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentInfo> getAll() {
		List<StudentInfo> list = new ArrayList<>();
		list = hibernateTemplate.loadAll(StudentInfo.class);
		return list;
	}

	@Override
	public void add(StudentInfo studentObj)  {
		hibernateTemplate.save(studentObj);
		
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
