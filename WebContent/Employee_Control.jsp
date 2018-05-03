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
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile home screen</title> -->
</head>
<body>
	<div id="profileInfo" class="text-center">
		<div class="welcomeMsg">
			<h1 style="margin-top: 0px; padding-top: 30px; font-weight: bold;">Rowers
				Meet Employee Control Center</h1>
			<h3 style="padding-bottom: 10px;">With Great Power Comes Great
				Responsibility</h3>
			<c:choose>
				<c:when test="${role=='Manager'}">
					<div class="btn-group btnStyle" style="width: 100%;">

						<form action="AddEmployee.jsp" method="post" class="text-center">
							<button type="submit" style="width: 20%; height: 100%;">Add Employee</button>
						</form>
						<form action="deleteemployee" method="post" class="text-center">
							<button type="submit" style="width: 20%; height: 100%;">Delete Employee</button>
						</form>
						<form action="sales" method="post" class="text-center">
							<button type="submit" style="width: 20%; height: 100%;">Sales Report</button>
						</form>
						<form action="revenue" method="post" class="text-center">
							<button type="submit" style="width: 20%; height: 100%;">Revenue By Profile</button>
						</form>
						<form action="login.html" method="post" class="text-center">
							<button type="submit" style="width: 20%; height: 100%;">Logout</button>
						</form>
					</div>
				</c:when>
				<c:otherwise>
					<div class="btn-group btnStyle" style="width: 100%;">

						<form action="recorddate" method="post" class="text-center">
							<button type="submit" style="width: 25%; height: 100%;">Record a date</button>
						</form>
						<form action="profile_ban.html" method="post" class="text-center">
							<button type="submit" style="width: 25%; height: 100%;">Ban Customer</button>
						</form>
						<form action="emaillist" method="post" class="text-center">
							<button type="submit" style="width: 25%; height: 100%;">List emails</button>
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
				});
			</script>

			<form method="post" class="infoTable">
				<div class="tableDiv">
					<table id="mainTable">
						<tr>
							<th colspan="2" style="background-color: #900; color: #fff;">Employee Information</th>
						</tr>
						<tr>
							<td style="font-weight: bold;">Employee:</td>
							<td><c:out value="${role}" /></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">SSN:</td>
							<td><c:out value="${SSN}" /></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Hourly Wage:</td>
							<td><c:out value="${wage}" /></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Working Since:</td>
							<td><c:out value="${start}" /></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
</body>
</html>