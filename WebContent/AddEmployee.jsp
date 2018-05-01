<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
   	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link href="assets/css/signin.css" rel="stylesheet">
	<link rel='icon' href='favicon.ico' type='image/x-icon'/>
</head>


<body>
<div class="page-header pheader">
  <h1 class="RowersMeet" style="margin-top: 0px; font-weight:bold;">Rower's Meet Add Employee</h1>
  <h4 class="RowersMeetDetail">Add a new employee</h4>
</div>
<br>
<div id="secondProf" class="container signin text-center">
	<div class="signInh2">
		<h2 class="form-signin-heading" style="background-color: #900; margin-top:0px; padding-top:10px; padding-bottom:10px; color:#fff;">Please enter employee info</h2>
	</div>
	<br>
	<form class="form-add_employee signInFrm" method="post" action="">
        <div class = "form-group">
			<label for="empSSN" class = "sr-only">SSN</label>
			<input type="text" id="empSSN" name="empSSN" class="form-control" placeholder="SSN" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empPass" class = "sr-only">Password</label>
			<input type="text" id="empPass" name="empPass" class="form-control" placeholder="Password" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empFirst" class = "sr-only">First Name</label>
			<input type="text" id="empFirst" name="empFirst" class="form-control" placeholder="First Name" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empLast" class = "sr-only">Last Name</label>
			<input type="text" id="empLast" name="empLast" class="form-control" placeholder="Last Name" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empStreet" class = "sr-only">Street</label>
			<input type="text" id="empStreet" name="empStreet" class="form-control" placeholder="Street" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empCity" class = "sr-only">City</label>
			<input type="text" id="empCity" name="empCity" class="form-control" placeholder="City" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empState" class = "sr-only">State</label>
			<input type="text" id="empState" name="empState" class="form-control" placeholder="State" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empZip" class = "sr-only">Zipcode</label>
			<input type="text" id="empZip" name="empZip" class="form-control" placeholder="Zipcode" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empEmail" class = "sr-only">Email</label>
			<input type="text" id="empEmail" name="empEmail" class="form-control" placeholder="Email" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empTelephone" class = "sr-only">Telephone</label>
			<input type="text" id="empTelephone" name="empTelephone" class="form-control" placeholder="Telephone" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empRole" class = "sr-only">Role</label>
			<input type="text" id="empRole" name="empRole" class="form-control" placeholder="Role" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empStart" class = "sr-only">Start Date</label>
			<input type="text" id="empStart" name="empStart" class="form-control" placeholder="Start Date (YYYY-MM-DD)" required autofocus>
		</div>
		<div class = "form-group">
			<label for="empHR" class = "sr-only">Hourly Rate</label>
			<input type="text" id="empHR" name="empHR" class="form-control" placeholder="Hourly Rate" required autofocus>
		</div>
        
        
        <button class="btn btn-primary btn-block bttnSignIn" type="submit">Sign in</button>
     </form>
</div>

</body>
</html>