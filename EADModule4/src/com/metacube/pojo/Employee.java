package com.metacube.pojo;

/**
 * Pojo class of employee.
 */
public class Employee {

	public String fullName;
	public String gender;
	public String email;
	public String password;
	public Long contactNumber;
	public String organization;

	public Employee(String fullName, String gender, String email,String password, Long contactNumber, String organization) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.organization = organization;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

}
