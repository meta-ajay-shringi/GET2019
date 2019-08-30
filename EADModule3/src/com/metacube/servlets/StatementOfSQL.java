package com.metacube.servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementOfSQL {

	public static int insertData(String first_name, String last_name,
			String father_name, String email, int class_no, int age) {
		int a = Integer.MIN_VALUE;
		try {

			ConnectionToDbms obj = new ConnectionToDbms();
			Connection connObj = obj.connectionObject();
			Statement stmt = connObj.createStatement();

			Query query = new Query();

			PreparedStatement pstmt = connObj
					.prepareStatement(query.insertStudentDetails);
			pstmt.setString(1, first_name);
			pstmt.setString(2, last_name);
			pstmt.setString(3, father_name);
			pstmt.setString(4, email);
			pstmt.setInt(5, class_no);
			pstmt.setInt(6, age);

			a = pstmt.executeUpdate();
			stmt.close();
			pstmt.close();

			// Connection Object Closed.
			connObj.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return a;
	}

	public static ResultSet showStudent() {
		ResultSet rs = null;
		try {

			ConnectionToDbms obj = new ConnectionToDbms();
			Connection connObj = obj.connectionObject();
			Statement stmt = connObj.createStatement();

			Query query = new Query();
			rs = stmt.executeQuery(query.showStudents);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return rs;
	}

	public static int updateDetails(int id, String firstname, String lastname,
			String fathername, String Semail, int class_no, int Sage) {
		int rs = Integer.MIN_VALUE;
		try {

			ConnectionToDbms obj = new ConnectionToDbms();
			Connection connObj = obj.connectionObject();
			Statement stmt = connObj.createStatement();

			Query query = new Query();
			rs = stmt.executeUpdate(query.UpdateStudentData(id, firstname,
					lastname, fathername, Semail, class_no, Sage));

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet studentData(int id) {
		ResultSet rs = null;
		try {

			ConnectionToDbms obj = new ConnectionToDbms();
			Connection connObj = obj.connectionObject();
			Statement stmt = connObj.createStatement();
			Query query = new Query();
			rs = stmt.executeQuery(query.studentdata(id));
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet studentDataSearch(String firstName, String lastName) {
		ResultSet rs = null;
		try {

			ConnectionToDbms obj = new ConnectionToDbms();
			Connection connObj = obj.connectionObject();
			Statement stmt = connObj.createStatement();
			Query query = new Query();
			rs = stmt.executeQuery(query.SearchStudentDetails(firstName,
					lastName));

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return rs;
	}

	public static ResultSet studentSearchByClass(String firstname,
			String lastname, int classNo) {
		ResultSet rs = null;
		try {

			ConnectionToDbms obj = new ConnectionToDbms();
			Connection connObj = obj.connectionObject();
			Statement stmt = connObj.createStatement();
			Query query = new Query();
			rs = stmt.executeQuery(query.SearchByClass(firstname, lastname,
					classNo));
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return rs;
	}
}