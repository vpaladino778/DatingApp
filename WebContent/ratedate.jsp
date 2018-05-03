<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link href="assets/css/signin.css" rel="stylesheet">
</head>

<body>
<div class="page-header pheader">
  <h1 style="margin-top: 0px; font-weight:bold;">Rate Your Date</h1>
  <h4>Enter your date rating</h4>
</div>
<br>

<div id="signin" class="container signin text-center">
	<div class="signInh2">
		<h2 class="form-signin-heading" style="background-color: #900; margin-top:0px; padding-top:10px; padding-bottom:10px; color:#fff;">Rate your date</h2>
	</div>
	<br>
	<form class="form-signin signInFrm" method="post" action="ratedate">
        
        <div class="form-group" >
        	<label for="Profile1" class="sr-only">Profile1 Name</label>
        	<input type="text" id="Profile1" name="Profile1" class="form-control" placeholder="Profile1" required autofocus>
        	<label for="Profile2" class="sr-only">Profile2 Name</label>
        	<input type="text" id="Profile2" name="Profile2" class="form-control" placeholder="Profile2" required autofocus>
        	<label for="Time" class="sr-only">Date and Time (YYY-MM-DD HH:MM:SS)</label>
        	<input type="text" id="Time" name="Time" class="form-control" placeholder="Date and Time" required autofocus>
        	<label for="Rating" class="sr-only">Your Rating</label>
        	<input type="number" id="rating" name="Rating" class="form-control" placeholder="Rating" required autofocus>
        </div>
        
        <button class="btn btn-primary btn-block bttnSignIn" type="submit">Submit</button>
        
	</form>
</div>
</body>
</html>