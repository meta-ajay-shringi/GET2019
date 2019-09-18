package com.metacube.EADsession12.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "student")
public class StudentInfo extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Sid")
	private int id;

	@Column(name = "First_name")
	@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "first name should be alphabetical")
	@Size(min = 2, max = 15, message = "{fName}")
	private String firstname;

	@Column(name = "Last_name")
	@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "last name should be alphabetical")
	@Size(min = 2, max = 15, message = "{lName}")
	private String lastname;

	@Column(name = "Father_name")
	@Pattern(regexp = "^[a-zA-Z ]{0,50}", message = "father name should be alphabetical")
	@Size(min = 2, max = 50, message = "{blankFatherName}")
	private String fathername;

	@Column(name = "Email")
	@NotBlank(message = "{blankEmail}")
	@Email
	private String email;

	@Column(name = "Student_class")
	@NotBlank
	@Min(value = 1)
	@Max(value = 12)
	private String classNo;
	
	@Column(name = "age")
	@NotBlank
	@Min(value = 1)
	@Max(value = 100)
	private String age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StudentInfo() {

	}

	public StudentInfo(
			int id,
			@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "first name should be alphabetical") @Size(min = 2, max = 15, message = "{fName}") String firstname,
			@Pattern(regexp = "^[a-zA-Z ]{0,15}", message = "last name should be alphabetical") @Size(min = 2, max = 15, message = "{lName}") String lastname,
			@Pattern(regexp = "^[a-zA-Z ]{0,50}", message = "father name should be alphabetical") @Size(min = 2, max = 50, message = "{blankFatherName}") String fathername,
			@NotBlank(message = "{blankEmail}") @Email String email,
			@NotBlank @Min(1) @Max(12) String classNo,
			@NotBlank @Min(1) @Max(100) String age) {
		super();
		this.id = id;
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
