package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentInformation
 */
@WebServlet("/StudentInformation")
public class StudentInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String fatherName = request.getParameter("fathername");
		String email = request.getParameter("email");
		String classNo = request.getParameter("class");
		String age = request.getParameter("age");

		response.setContentType("text/html");

		StatementOfSQL statementOfSQL = new StatementOfSQL();
		int a = statementOfSQL.insertData(firstName, lastName, fatherName,email, Integer.parseInt(classNo), Integer.parseInt(age));

		if (a == 1) {
			out.print(firstName + " ");
			out.print("<br><br>");
			out.print(" Data Successfully Added");
		} else {
			out.print(firstName + " ");
			out.print("<br><br>");
			out.print("Student Data Not Added");
			out.print("<br><br>");
			out.print("Email Id already exist");
		}

	}

}
