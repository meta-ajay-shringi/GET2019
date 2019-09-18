package com.metacube.EADsession12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.EADsession12.model.StudentInfo;


/**
 *  student repository class.
 */

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Long> {
 
	/**
	 * This method is used for find all student that have this email.
	 * @param email, email of student.
	 * @return, return all student that have this email.
	 */
    public List<StudentInfo> findByemailContainingIgnoreCase(String email);


}