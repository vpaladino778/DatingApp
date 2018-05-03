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
		<link rel='icon' href='favicon.ico' type='image/x-icon'/>
	</head>
	<body  style="height:100%;">
		<div class="page-header pheader">
  			<h1 style="margin-top: 0px; font-weight:bold;">Employee Deletion</h1>
  			<h3 style="margin-top: 0px; font-weight:bold;">Only delete employees not working for Rower's Meet</h3>
		</div>
		<div id="profileList" class="container text-center">
			
			<div class="selectProf">
				<h2 class="selectProfh2" style="background-color: #900; margin-top:0px; padding-top:10px; padding-bottom:10px; color:#fff;">Please select an employee</h2>
			</div>
			
			<form action="deleteemp2" method="post" class="text-center selectProfFrm">
				
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
				<c:forEach var="employees" items="${eList}">
					<input id="employee" class="btn btn-lg btn-primary btn-block bttnProf" type="Submit" name="Employee" value="${employees}">
				</c:forEach>

			</form>
			<form class="createProfFrm">
				<div class="text-center newProfiles">
					<input id="newProfile" class="btn btn-med btn-primary btn-block bttnProf" onClick="goBack()" name="CancelDelete" value="Cancel">
				</div>
			</form>
			<script>
			function goBack(){
				window.history.back();
			}
			</script>

		</div>

	</body>
</html>