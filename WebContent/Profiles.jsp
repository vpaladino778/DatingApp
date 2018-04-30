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
<title>Profiles</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="assets/css/profiles.css" rel="stylesheet">

</head>

<body>

	<!-- Header -->
	<div id="new-header">
		<script>
            $("#new-header").load("header.html");
        </script>
	</div>

	<!-- Profile List -->

	<ul>
		<c:forEach items="${profiles}" var="profile">

			<div class="container">
				<div class="row">
					<div
						class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">${profile.profileid}</h3>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-3 col-lg-3 " align="center">
										<img alt="User Pic"
											src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png"
											class="img-circle img-responsive">
									</div>

									<div class=" col-md-9 col-lg-9 ">
										<table class="table table-user-information">
											<tbody>
												<tr>
													<td>Age</td>
													<td>${profile.age}</td>
												</tr>

												<tr>
													<td>Gender</td>
													<td>${profile.m_f}</td>
												</tr>

												<tr>
													<td>Hobbies:</td>
													<td>${profile.hobbies}</td>
												</tr>
												<tr>
													<td>Height:</td>
													<td>${profile.height}cm</td>
												</tr>
												<tr>
													<td>Weight:</td>
													<td>${profile.weight}lbs</td>
												</tr>
												<tr>
													<td>Hair Color:</td>
													<td>${profile.haircolor}</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="panel-footer">
								<a data-original-title="Like this user" data-toggle="tooltip"
									type="button" class="btn btn-sm btn-primary"><i
									class="glyphicon glyphicon-thumbs-up"></i></a> <a
									data-original-title="Like this user" data-toggle="tooltip"
									type="button" class="btn btn-sm btn-danger"><i
									class="glyphicon glyphicon-thumbs-down"></i></a> </span>
							</div>

						</div>
					</div>
				</div>
			</div>



		</c:forEach>
	</ul>
</body>
</html>