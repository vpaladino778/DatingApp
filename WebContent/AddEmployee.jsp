<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="form-edit_profile" method="post" action="editprofile">
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
		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Add Employee</button>
	</form>

</body>
</html>