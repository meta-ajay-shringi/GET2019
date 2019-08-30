package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		ResultSet rs = StatementOfSQL.studentDataSearch(firstname, lastname);
		// out.print(firstname);

		out.print("<html><head><style> td { padding: 15px; } table { border = 2px } </style></head><body>");
		out.print("<h1>Student details</h1> <table><tr><td>First Name</td><td>Last Name </td> <td>Father Name</td> <td>Email</td><td>Class</td> <td>Age</td> </tr> ");
		try {
			while (rs.next()) {

				out.print("<tr>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");

				out.print("<td>");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(6));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(7));
				out.print("</td>");
				out.print("</tr>");
			}

			out.print("</table>");

			out.print("<form method = 'POST' action = 'http://localhost:8080/EADsession3/SearchStudent?first_name="
					+ firstname
					+ "&last_name="
					+ lastname
					+ "'> "
					+ "<input type = 'text' name = 'Sclass' placeholder = 'please enter class'  required>"
					+ "<button type = 'submit'> Submit </button>" + "</form>");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");

		int classNo = Integer.parseInt(request.getParameter("Sclass"));

		ResultSet rs = StatementOfSQL.studentSearchByClass(firstname, lastname,
				classNo);
		out.print("<html><head><style> td { padding: 15px; } table { border = 2px } </style></head><body>");
		out.print("<h1>Student details</h1> <table><tr><td>First Name</td><td>Last Name </td> <td>Father Name</td> <td>Email</td><td>Class</td> <td>Age</td> </tr> ");
		try {
			while (rs.next()) {

				out.print("<tr>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");

				out.print("<td>");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(6));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(7));
				out.print("</td>");
				out.print("</tr>");
			}

			out.print("</table>");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		out.print("</body></html>");
	}

}
