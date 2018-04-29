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
	</head>
	<body>
		
		<div id="profileList">
<<<<<<< HEAD
			<form action="profileList" method="post" class="text-center profileForm">
=======
			<form action="openhome" method="post" class="text-center profileForm">
>>>>>>> 960b96d71eab9d3b2f2a8d1c8273b5a486aa4a0d
				<h3>Please select your profile</h3>
				<!-- <input type="hidden" name="loginEmail" value="${param.profileID}">
				<input type="hidden" name="loginEmail" value="${param.loginEmail}">
				<input type="hidden" name="loginEmail" value="${param.dars}">
				<input type="hidden" name="loginEmail" value="${param.dare}">
				<input type="hidden" name="loginEmail" value="${param.dgr}">
				<input type="hidden" name="loginEmail" value="${param.gender}">
				<input type="hidden" name="loginEmail" value="${param.hobbies}">
				<input type="hidden" name="loginEmail" value="${param.height}">
				<input type="hidden" name="loginEmail" value="${param.weight}">
				<input type="hidden" name="loginEmail" value="${param.hair}">
				<input type="hidden" name="auth" value="${auth}">-->
				<c:forEach var="profiles" items="${pList}">
					<input id="profile" type="Submit" name="Username" value="${profiles}">
				</c:forEach>

			</form>
			<form action = "second_prof.html">
				<div class="text-center newProfiles">
					<p>Don't have a profile yet?</p>
					<input id="newProfile" type="Submit" name="NewProfile" value="Create new profile!">
				</div>
			</form>


		</div>

	</body>
</html>