package com.metacube.EADsession8.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * pojo class for student information.
 */
public class StudentInfo {

	@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "first name should be alphabetical")
	@Size(min = 2, max = 15, message = "{fName}")
	private String firstname;

	@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "last name should be alphabetical")
	@Size(min = 2, max = 15, message = "{lName}")
	private String lastname;

	@Pattern(regexp = "^[a-zA-Z ]{0,50}", message = "father name should be alphabetical")
	@Size(min = 2, max = 50, message = "{blankFatherName}")
	private String fathername;

	@NotBlank(message = "{blankEmail}")
	@Email
	private String email;

	@NotBlank
	@Min(value = 1)
	@Max(value = 12)
	private String classNo;

	@NotBlank
	@Min(value = 1)
	@Max(value = 100)
	private String age;

	public StudentInfo() {

	}

	public StudentInfo(String firstname, String lastname, String fathername,
			String email, String classNo, String age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.fathername = fathername;
		this.email = email;
		this.classNo = classNo;
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentInfo [firstname=" + firstname + ", lastname=" + lastname
				+ ", fathername=" + fathername + ", email=" + email
				+ ", classNo=" + classNo + ", age=" + age + "]";
	}

}
