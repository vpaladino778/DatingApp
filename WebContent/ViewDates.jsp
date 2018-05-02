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
<link href="assets/css/viewdates.css" rel="stylesheet">
<link rel='icon' href='favicon.ico' type='image/x-icon'/>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
<title>View Dates</title>
</head>
<body>
<div class="">
	<div class="dateHeader text-center">
		<h1 style="margin-top: 0px; padding-top: 30px; font-weight: bold; display: inline;">View and Manage Your Dates</h1>
		<h3 style="padding-bottom: 10px;">Manage past and currently pending dates</h3>
	</div>
	<div class="centerContent">
		<div class="btnManager text-center" style="width: 100%; margin:0 auto;">
			<div class="toggleHeader">		
				<h2 class="toggleTitle">Toggle between Past and Pending Dates</h2>
			</div>
			<div class="btn-group btnStyle" style="width: 100%; margin: 0 auto;">
				<button type="button" style="width: 50%;" onClick="">View Past</button>
				<button type="button" style="width: 50%;" onClick="">View Pending</button>
			</div>
	
		</div>
		<div class="pastDateDiv">
		<c:forEach items="${pastDates}" var="pastDate">
		<div class="pastDateCard">
			<div class="btnManager text-center" style="width: 100%; margin:0 auto;">
				<div class="btn-group btnStyle" style="width: 100%; margin: 0 auto;">
					<button type="button" style="width: 50%;" onClick=""></button>
					<button type="button" style="width: 50%;" onClick="">View Pending</button>
				</div>
	
			</div>
		
			<table>
				<tr>
					<td>Met with:</td>
					<td>${pastDate.otherUser}</td>
					<td>Started at:</td> 
					<td>${pastDate.dateTime}</td>
				</tr>
				<tr>
					<td>Met at:</td>
					<td>${pastDate.location}</td>
					<td>Thoughts on the date:</td>
					<td>${pastDate.comments}</td>
				</tr>
				<tr>
					<td>Your Rating</td>
					<td>${pastDate.yourRating}</td>
					<td>Their Rating</td>
					<td>${pastDate.otherRating}</td>
				</tr>
			</table>
    	</div>
		</c:forEach>
		</div>
	</div>
</div>
<script>
	
</script>

</body>
</html>