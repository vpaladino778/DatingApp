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
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile home screen</title> -->
</head>
<body>
	<div id="profileInfo">
		<form method = "post">
			<h1><span style="background-color: #000080; color: #ff0000;">Welcome to your dating profile!</span></h1>
			<h3><span style="background-color: #000080; color: #ff0000;">This is the information that other users can see</span></h3>
			<hr />
			<h3>Personal Information:</h3>
			<p>ProfileID: <c:out value="${param.profileID}"/></p>
			<p>Email: <c:out value="${param.loginEmail}"/></p>
			<p>Age: <c:out value="${param.age}"/></p>
			<p>Dating age Range Start: <c:out value="${param.dars}"/>, End: <c:out value="${param.dare}"/></p>
			<p>Dating Geo Range: <c:out value="${param.dgr}"/></p>
			<p>Gender: <c:out value="${param.gender}"/></p>
			<p>Hobbies: <c:out value="${param.hobbies}"/></p>
			<p>Height: <c:out value="${param.height}"/></p>
			<p>Weight: <c:out value="${param.weight}"/></p>
			<p>Hair Color: <c:out value="${param.hair}"/></p>
		</form>
		<form action = "Edit_Profile.html" method = "post" class="text-center">
			<button type="submit">Edit your profile!</button>
		</form>
		<br>
		<form action = "viewprivate" method = "post" class = "text-center">
			<button type="button">View your private info!</button>
	<!-- <p>Test<c:out value="${param.Username}"/></p>
	<c:out value="${param.auth}"/>
	<c:out value="${param.loginEmail}"/> -->
		</form>
	</div>
</body>
</html>