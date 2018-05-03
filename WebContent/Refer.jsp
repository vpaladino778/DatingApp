<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<link href="assets/css/signin.css" rel="stylesheet">
	<link href="assets/css/home.css" rel="stylesheet">
	<link href="assets/css/header.css" rel="stylesheet">
<link rel='icon' href='favicon.ico' type='image/x-icon' />
</head>



<body>
	<div class="page-header pheader">
		<h1 class="RowersMeet" style="margin-top: 0px; font-weight: bold;">Rower's
			Meet Profile Suggestions</h1>
		<h4 style="padding-bottom: 10px;" class="RowersMeetDetail">Please suggest a profile for a user</h4>
	</div>
	<br>
	<div id="signin" class="container signin text-center">
		<div class="signInh2">
			<h3 class="form-signin-heading"
				style="background-color: #900; margin-top: 0px; padding-top: 10px; padding-bottom: 10px; color: #fff;">Please Input Suggestion Info:</h3>
		</div>
		<br>
		<form class="form-edit_profile signInFrm" method="post"
			action="referprof">
			<div class="form-group">
				<label for="prof1" class="sr-only">Prof1</label> <input type="prof1"
					id="prof1" name="prof1" class="form-control" placeholder="Profile 1"
					required autofocus>
			</div>
			<input type="hidden" name="profile2" value = "${param.profile2}"/>
			<button class="btn btn-primary btn-block bttnSignIn" type="submit">Submit</button>
		</form>



	</div>

</body>
</html>