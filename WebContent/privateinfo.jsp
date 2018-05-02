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
		<link href="assets/css/home.css" rel="stylesheet">
		<link href="assets/css/header.css" rel="stylesheet">
		<link rel='icon' href='favicon.ico' type='image/x-icon'/>
<title>Private Information</title>
</head>
<body>
	<div id="profileInfo" class="text-center">
		<div class="welcomeMsg">
			<h1 style="margin-top:0px; padding-top:30px; font-weight:bold;">Private Profile Info</h1>
			<h3 style="padding-bottom:10px;">This is information that other users cannot see</h3>
		
		<div class="btn-group btnStyle" style="width:100%;">
		
			<form action="change_pass.html" method="post" class="text-center">
				<button type = "submit" style="width:33.33%;">Change your password!</button>
			</form>
			<form action="openhome" method="post" class="text-center">
				<input type="hidden" name = "Username" value = "${loggedIn}"/>
				<button type = "submit" style="width:33.33%;">Return</button>
			</form>
			<form action="login.html" method="post" class="text-center">
				<button type = "submit" style="width:33.33%;">Logout</button>
			</form>
		
		</div>
		</div>
		
		<script>
			$(document).ready(function() {
			  var tableWidth = $("#mainTable").width();
			  var tableHeight = $("#mainTable").height();
			  
			  $(".tableDiv").width(tableWidth);
			  $(".tableDiv").height(tableHeight);
			}) ;
		</script>
	
		<form method = "post" class = "infoTable">
		<div class="tableDiv">
		<table id="mainTable">
				<tr>
					<th colspan="2" style="background-color: #900; color:#fff;">Private Information</th>
				</tr>
				<tr>
					<td style="font-weight:bold;">SSN:</td>
					<td><c:out value="${SSN}"/></td>
				</tr>
				<tr>
					<td style="font-weight:bold;">Email:</td>
					<td><c:out value="${email}"/></td>
				</tr>
				<tr>
					<td style="font-weight:bold;">Phone:</td>
					<td><c:out value="${phone}"/></td>
				</tr>
				<tr>
					<td style="font-weight:bold;">Street, City, State, Zip:</td>
					<td><c:out value="${street} ${city} ${state} ${zip}"/></td>
				</tr>
			</table>
			</div>
		</form>
		
	</div>
</body>