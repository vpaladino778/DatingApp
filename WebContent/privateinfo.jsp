<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link href="assets/css/profilelist.css" rel="stylesheet">
<title>Private Information</title>
</head>
<body>
	<div id="privateInfo">
		<form method = "post" class = "text-center">
			<h1><span style="background-color: #000080; color: #ff0000;">Private profile info</span></h1>
			<h3><span style="background-color: #000080; color: #ff0000;">This is the information that other users cannot see</span></h3>
			<hr />
			<h3>Private Information:</h3>
			<p>SSN: <c:out value="${param.SSN}"/></p>
			<p>Email: <c:out value="${param.email}"/></p>
			<p>Phone: <c:out value="${param.phone}"/></p>
			<p>Street, City, State, Zip: <c:out value="${param.street} ${param.city} ${param.state} ${param.zip}"/></p>
		</form>
		<form action="openhome" method = "post" class = "text-center">
			<button type = "submit">Go Back</button>
		</form>
		<form action="changepass" method="post" class="text-center">
			<button type = "submit">Change your password!</button>
		</form>
	</div>
</body>