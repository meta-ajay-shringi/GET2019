<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
	<title>Student Details</title>
	<style>
	</style>
</head>

<body>


	<div class="container">
		<form:form method="Post" modelAttribute="studentInfo">
			<h1>Student Form</h1>
			<form:errors cssClass="text-danger" />
			<div class="form-group">
				<form:label path="firstname">First Name :</form:label>
				<form:input path="firstname" cssClass="form-control" id="nameInputEmail1"
					placeholder="Please enter first name" />
				<form:errors path="firstname" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="lastname">Last Name :</form:label>
				<form:input path="lastname" cssClass="form-control" id="nameInputEmail1"
					placeholder="Please enter last name" />
				<form:errors path="lastname" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="fathername">First Name :</form:label>
				<form:input path="fathername" cssClass="form-control" id="nameInputEmail1"
					placeholder="Please enter father name" />
				<form:errors path="fathername" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="email">Email address</form:label>
				<form:input path="email" cssClass="form-control" id="exampleInputEmail1" placeholder="Enter email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="classNo">class </form:label>
				<form:input path="classNo" cssClass="form-control" id="exampleInputEmail1" type="number"
					placeholder="please enter class" />
				<form:errors path="classNo" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="age">age </form:label>
				<form:input path="age" cssClass="form-control" id="exampleInputEmail1" type="number"
					placeholder="Enter age" />
				<form:errors path="age" cssClass="text-danger" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>

			<form:label class="form-group" cssClass="text-success" path="firstname">${result}</form:label>
			<div>
				<a href="Homepage"> click hear for homepage</a>
			</div>
		</form:form>
	</div>
</body>

</html>