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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="assets/css/home.css" rel="stylesheet">
<link rel='icon' href='favicon.ico' type='image/x-icon'/>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile home screen</title> -->
</head>
<body>
	<div id="profileInfo" class="text-center">
		<div class="welcomeMsg">

			<!-- Header -->
			<img src="assets/img/oar.png" width="64" style="display: inline;padding-right:20px;">
			<h1 style="margin-top: 0px; padding-top: 30px; font-weight: bold; display: inline;">Welcome to your dating profile!</h1>
			<img src="assets/img/oar.png" width="64" style="display: inline;padding-left:20px;">

			<h3 style="padding-bottom: 10px;">This is the information that
				other users can see</h3>
			<c:choose>
			<c:when test="${ssn1==ssn2}">
			<div class="btn-group btnStyle" style="width: 100%;">
				<form action="profiles" method="post" class="text-center">

					<button type="submit" style="width: 14.28%; height: 100%;">Find
						Singles Near You!</button>
				</form>
				<form action="viewDates" method="post" class="text-center">
					<button type="submit" style="width:14.28%; height: 100%;">View Dates</button>
				</form>
				<form action="Edit_Profile.html" method="post" class="text-center">
					<button type="submit" style="width: 14.28%; height: 100%;">Edit
						your profile!</button>
				</form>
				<form action="likeeslikers" method="post" class="text-center">
					<button type="submit" style="width: 14.28%; height: 100%;">Likers-Likees</button>
				</form>
				<form action="rfsb" method="post" class="text-center">
					<button type="submit" style="width: 14.28%; height: 100%;">Refferrals-Suggestions</button>
				</form>
				<form action="viewprivate" method="post" class="text-center">
					<button type="submit" style="width: 14.28%; height: 100%;">View
						your private info!</button>
				</form>
				<form action="login.html" method="post" class="text-center">
					<button type="submit" style="width: 14.28%; height: 100%;">Logout</button>
				</form>

			</div>
			</c:when>
			<c:otherwise>
			<div class="btn-group btnStyle" style="width: 100%;">
				<form action="like" method="post" class="text-center">
					<input type="hidden" name="liker" value="${profileID}"/>
					<button type="submit" style="width: 25%; height: 100%;">Like Profile</button>
				</form>
				<form action="Refer.jsp" method="post" class="text-center">
					<input type="hidden" name="profile2" value="${profileID}"/>
					<button type="submit" style="width: 25%; height: 100%;">Refer</button>
				</form>
				<form action="Edit_Profile.html" method="post" class="text-center">
					<button type="submit" style="width: 25%; height: 100%;">Return</button>
				</form>
				<form action="login.html" method="post" class="text-center">
					<button type="submit" style="width: 25%; height: 100%;">Logout</button>
				</form>

			</div>
			</c:otherwise>
			</c:choose>
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
			<table id="mainTable">				<tr>
					<th colspan="2" style="background-color: #900; color: #fff;">Personal
						Information</th>
				</tr>
				<tr>
					<td style="font-weight: bold;">ProfileID:</td>
					<td><c:out value="${profileID}" /></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Email:</td>
					<td><c:out value="${loginEmail}" /></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Age:</td>
					<td><c:out value="${age}" /></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Dating Age Range Start:</td>
					<td><c:out value="${dars}" /></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Dating Age Range End:</td>
					<td><c:out value="${dare}" /></td>
				</tr>
				<tr>
					<td style="font-weight:bold;">Dating Geo Range:</td>
					<td><c:out value="${dgr}"/></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Gender</td>
					<td><c:out value="${gender}" /></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Hobbies:</td>
					<td><c:out value="${hobbies}" /></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Height:</td>
					<td><c:out value="${height}" /></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Weight:</td>
					<td><c:out value="${weight}" /></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">Hair Color:</td>
					<td><c:out value="${hair}" /></td>
				</tr>

			</table>
			</div>
		</form>
	</div>
</body>
</html>