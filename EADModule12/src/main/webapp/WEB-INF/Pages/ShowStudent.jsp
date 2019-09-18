<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

	<style>
		div {
			text-align: center;
		}

		p {
			margin: auto;
			text-align: center;
		}

		table {
			margin: auto;
		}

		td,
		th {
			padding: 20px;
		}
	</style>

	<title>students Data</title>
</head>

<body>

	<div align="center">
		<h1>Student Details</h1>
		<br>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Father's Name</th>
				<th>Student's Email</th>
				<th>Student's Class</th>
				<th>Student's Age</th>
			</tr>

			<c:forEach items="${studentList}" var="studentsList">
				<tr>
					<td>${studentsList.getFirstname()}</td>
					<td>${studentsList.getLastname()}</td>
					<td>${studentsList.getFathername()}</td>
					<td>${studentsList.getEmail()}</td>
					<td>${studentsList.getClassNo()}</td>
					<td>${studentsList.getAge()}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>

</html>