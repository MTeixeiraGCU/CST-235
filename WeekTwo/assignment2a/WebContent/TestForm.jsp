<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Test Form</title>
	</head>
	<body>
		<form method="POST" action="TestServlet">
			<label for="firstName">First Name:</label>
			<input id="firstName" name="firstName" type="text"/>
			<br/>
			<label for="lastName">Last Name:</label>
			<input id="lastName" name="lastName" type="text"/>
			<br/>
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>