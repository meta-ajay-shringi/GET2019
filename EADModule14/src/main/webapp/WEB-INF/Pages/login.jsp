<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
	<title>login</title>
		<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>		

	<body>
	
		<h1><strong>Student Login</strong></h1>
						
		<c:url value="/login" var="login"/>
		<div class="container">
		<div class="alert alert-danger">
        ${Error}
       </div>
		<form:form action="perform_login" method="post">
			<label>Username:</label> <input type="text" name="username" /> <br>
			<label>Password:</label> <input type="password" name="password" />
			<input type="submit"/>
		</form:form>
		
		
       </div>
	</body>
</html>
