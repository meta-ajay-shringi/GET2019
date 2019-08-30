package com.metacube.servlets;

/**
 * This class is used for perform query.
 */
public class Query {

	public static String insertStudentDetails = "INSERT INTO student(first_name,last_name,father_name,email,class,age) VALUES(?,?,?,?,?,?)";
	public static String showStudents = "SELECT first_name,last_name,father_name,email,class,age,student_id FROM student";

	public static String studentdata(int id) {
		return "SELECT * FROM student where student_id = " + id;
	}

	public static String UpdateStudentData(int id, String firstname,
			String lastname, String fathername, String Semail, int class_no,
			int Sage) {

		return "UPDATE student " + "SET first_name = '" + firstname + "', "
				+ "last_name = '" + lastname + "', " + "father_name = '"
				+ fathername + "', " + "email = '" + Semail + "', "
				+ "class = " + class_no + ", " + "age = " + Sage + " "
				+ " WHERE student_id = " + id;
	}

	public static String SearchStudentDetails(String firstname, String lastname) {

		return "SELECT * FROM student " + "WHERE first_name = '" + firstname
				+ "' AND " + "last_name = '" + lastname + "' ";
	}

	public static String SearchByClass(String firstname, String lastname,
			int classNo) {

		return "SELECT * FROM student " + "WHERE first_name = '" + firstname
				+ "' AND " + "last_name = '" + lastname + " ' AND "
				+ "class = " + classNo;
	}

}
