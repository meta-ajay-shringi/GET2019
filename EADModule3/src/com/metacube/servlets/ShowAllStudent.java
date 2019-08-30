package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAllStudent
 */
@WebServlet("/ShowAllStudent")
public class ShowAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAllStudent() {
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
		response.setContentType("text/html");

		if (request.getParameter("id") != null) {

			try {

				ResultSet rs2 = StatementOfSQL.studentData(Integer
						.parseInt(request.getParameter("id")));
				rs2.next();

				out.print("<html><head></head><body>");
				out.print("<form  action = './ShowAllStudent' method = 'Post' align = 'center' ><h1>Student details</h1>");
				out.print("<table align = 'center'> "
						+ "<tr><td>Student_id :</td> <td> <input type = 'text' name = 'id' value = '"
						+ rs2.getInt(1)
						+ "' readonly></td></tr>"
						+ "<tr><td>First Name :</td> <td> <input type = 'text' name = 'first_name' value = '"
						+ rs2.getString(2)
						+ "' required></td></tr>"
						+ "<tr><td>last Name :</td> <td> <input type = 'text' name = 'last_name' value = '"
						+ rs2.getString(3)
						+ "' required></td></tr>"
						+ "<tr><td>Father Name :</td> <td> <input type = 'text' name = 'father_name' value = '"
						+ rs2.getString(4)
						+ "' required></td></tr>"
						+ "<tr><td>Email :</td> <td> <input type = 'text' name = 'Semail' value = '"
						+ rs2.getString(5)
						+ "' required></td></tr>"
						+ "<tr><td>Class :</td> <td> <input type = 'text' name = 'Sclass' value = '"
						+ rs2.getInt(6)
						+ "' required></td></tr>"
						+ "<tr><td>Age :</td> <td> <input type = 'text' name = 'Sage' value = '"
						+ rs2.getInt(7)
						+ "' required></td></tr>"
						+ "<tr> <td>  <button type = 'submit' colspan='2'> Submit </button></tr>"
						+ "</table></form>");
				out.print("</body></html>");

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			}

		}

		else {

			StatementOfSQL statementOfSQL = new StatementOfSQL();
			ResultSet rs = statementOfSQL.showStudent();
			out.print("<html><head><style> td { padding: 15px; } table { border = 2px } </style></head><body>");

			out.print("<h1>Student details</h1> <table><tr><td>First Name</td><td>Last Name </td> <td>Father Name</td> <td>Email</td><td>Class</td> <td>Age</td> <td>Update </td></tr> ");
			try {
				while (rs.next()) {

					out.print("<tr>");
					out.print("<td>");
					out.print(rs.getString(1));
					out.print("</td>");

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
					out.print(rs.getInt(5));
					out.print("</td>");
					out.print("<td>");
					out.print(rs.getInt(6));
					out.print("</td>");
					out.print("<td>");
					// out.print("<button>UPDATE</button>");
					out.print("<a href='http://localhost:8080/EADsession3/ShowAllStudent?id="
							+ rs.getInt(7) + "'>Update</a>");
					out.print("</td>");
					out.print("</tr>");
				}

				out.print("</table>");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		out.print("</body></html>");

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String fathername = request.getParameter("father_name");
		String Semail = request.getParameter("Semail");
		int class_no = Integer.parseInt(request.getParameter("Sclass"));
		int Sage = Integer.parseInt(request.getParameter("Sage"));

		int a = StatementOfSQL.updateDetails(id, firstname, lastname,
				fathername, Semail, class_no, Sage);
		System.out.print(a);

		if (a == 1) {
			out.print("Data Updated.");
		} else {
			out.print("Data Not Updated.");
		}
	}

}
