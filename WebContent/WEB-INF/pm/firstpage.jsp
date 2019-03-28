<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> Project Manager TRM</title>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
		
		<link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/js/bootstrap4-toggle.min.js"></script>
		
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    	<link href='<c:url value="/resources/css/temp.css" />' rel="stylesheet">
		<script src="<c:url value="/resources/js/landing.js" />"></script>
		


		
	</head>
	<body>
		<nav class="navbar navbar-expand-sm navbar-dark nav-upper" style="background-color:rgb(51, 96, 223);">
			<img src="trm.png" height="45vh" width="131vh" style="margin-right: 25px" />
			<!-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navLower" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button> -->
			<!-- <div class="collapse navbar-collapse" id="navUpper"> -->
			<div class="w-100">
				<ul class="navbar-nav mr-auto w-100"> <!--w-100 makes the dropdown go to right side-->
					<li class="nav-item dropdown ml-auto">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fas fa-user" title="Profile" style="font-size:25px"></i>
							</a>
							<div class="dropdown-menu dropdown-menu-right bg-light" aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#viewInfo" data-toggle="modal" data-target="#viewInfo">View Info</a>
									<a class="dropdown-item" href="#changePassword" data-toggle="modal" data-target="#changePassword">Change Password</a>
									<a  class="dropdown-item" href="Login.html">Sign Out</a>
							</div>
					</li>
				</ul>
			</div>
		</nav>
		<nav class="navbar collapse navbar-collapse navbar-lower navbar-expand-sm" id="navLower" style="background-color:rgb(51, 96, 223)">
			<div class="container offset-md-1">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
					<a class="nav-link active" href="landing.html"><i class="fas fa-home" title="Home" style="font-size:25px; color:cornsilk"></i> <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="report"><i class="fas fa-chart-area" title="Reports" style="font-size:25px; color:cornsilk"></i></a>
				</li>
				<li class="nav-item dropdown ml-auto">
					<a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-file" title="Requests" style="font-size:25px; color:cornsilk"></i></a>
					<div class="dropdown-menu bg-light" aria-labelledby="dropdown03">
						<a class="dropdown-item" data-toggle="modal" data-target="#CreateRequestModal" >Create New Request</a>
						<a class="dropdown-item" onclick="toggle()"><div id="message"></div></a>
					</div>
				</li>
			</ul>
			</div>
		</nav>

		<!--MAIN CONTAINER FOR THE PAGE BELOW NAV BAR-->
		<div id="mainContainer" class="container-fluid" style="background-color:rgb(185, 184, 184)">
			<div id="buttonRowContainer" class="btn_row row card-columns offset-lg-1 col-lg-10" style="background:rgb(226, 224, 224);">
				<div><a href="TrainingReq/"><button id="createNewRequest" class = "btn btn-info" >Create New Training Request</button></a></div>
				<div><input type="checkbox" id="mycheck" checked onchange="test()" data-offstyle="success"  data-toggle="toggle" data-off="Viewing Processed Requests " data-on="Viewing Pending Requests" style="white-space:nowrap" data-class="fast"></input></div>
			</div>

		<div id="cardContainer" class="row card-columns offset-lg-1 col-lg-10 my-contain" style="min-height:65vh;display:flex;background:rgb(226, 224, 224);">
			
			<!--Cards-->
			
		<c:forEach var="card" items="${Cards}">
			<div class="col-sm-4 my-card" id="${card.training_request_id}" >
			<script>
				statpop(${card.status.status},${card.training_request_id});
			</script>
				<div class="card border">
					<div class="card-body">
						<ul class="list-group list-group-flush my-list-group">
							<li class="list-group-item">
								<h5>${card.training_request_id}<!--<br> Status number: ${card.status.status }--></h5>
							</li>
							<li class="list-group-item">
								<h7 class="card-title">Module Name: ${card.request_training_module} 

									<button data-html="true" type="button" title="Module" data-toggle="popover"
										class="btn btn-sm btn-light pull-right moduleDetails my-fa" 
										data-content="Module type: ${card.request_training_type }<br> Module Scope: ${ card.request_training_module_scope}<br> Training Mode: ${card.request_training_mode }<br><a href='update/module/${card.training_request_id}'><button class='btn btn-primary btn-sm'>Update</button></a>">
										<i class="fa fa-ellipsis-h "></i></button></h5>

								<p data-html="true" class="card-text"><i class="fa fa-calendar" aria-hidden="true"></i> 	${card.request_start_date }<br>Number of Participants: ${card.request_approx_participant }<br>
								Spoc: ${card.spoc.last_name }, ${card.spoc.first_name }
									<button data-html="true" type="button" class="btn btn-sm btn-light pull-right spocDetails my-fa" 
									data-content="Vertical: ${card.vertical }<br>Email: ${card.spoc.email }<br>Phone Number: ${card.spoc.phone_number }<br>Location: ${card.spoc.city }, ${card.spoc.state }"
										data-toggle="popover" ><i class="fa fa-ellipsis-h"></i></button>
								</p>
							</li>
							
							<li class="list-group-item">
								<a href="approval/${card.training_request_id}"><button type="button" class="btn btn-sm btn-success approve-btn">Approval Decision</button></a>
								<!-- Status hover-->
									<button type="button" class="btn btn-sm btn-light pull-right status my-fa ${card.status.status }"data-html="true" data-toggle="popover"   >
										<i class="fa fas fa-question-circle yellow-fa" ></i>
										<i class="fa fa-spinner green-fa"></i>
										<i class="fa fa-calendar-check-o red-fa"></i>
									</button>
								<!-- Details Button-->
									<button data-html="true" type="button" class="btn btn-sm btn-light pull-right expandDetails my-fa" data-toggle="popover"
									data-content="End Date: ${card.request_end_date }<br> Location: ${card.request_location }<br>Timezone: ${card.request_time_zone }<br> <a href='update/date/${card.training_request_id}'><button class='btn btn-primary btn-sm updatebtn' > Update</button></a> <hr> Date Requested: ${card.time_requested }<br>Justification: ${card.justification_of_request }<br><a href='update/details/${card.training_request_id}'><button class='btn btn-primary btn-sm updatebtn' >Update</button></a>"><i class="fa fa-bars"></i>
									</button>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</c:forEach>
			

		</div>
				




		<!-- Change Password Modal -->
		<div id="changePassword" class="modal fade">
			<div class="modal-dialog modal-md" role="document">
				<div class="modal-content">
					<div class="modal-header" style="background-color: rgb(67, 132, 253)">
							<h5 class="modal-title extra-title muted" id="exampleModalLabel">Password Reset</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close" style="background-color: rgb(67, 132, 253)">
								<span aria-hidden="true">&times;</span>
							</button>
					</div>
					<div class="modal-body form-horizontal" style="background-color: rgb(183, 197, 228)">
							<form id="newPass" style="padding-left:25px; padding-top: 10px; margin-right: -10vh">
								<div class="form-group row">
									<label for="staticEmail" class="col-sm-4 col-form-label newPassLabel">Current Password</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="staticEmail" placeholder="Current Password" minlength="8" required>
									</div>
								</div>
								<div class="form-group row">
									<label for="inputPassword" class="col-sm-4 col-form-label newPassLabel">New Password</label>
									<div class="col-sm-6">
										<input type="password" class="form-control" id="inputPassword" placeholder="New Password" minlength="8" required>
									</div>
								</div>
								<div class="form-group row">
									<label for="inputPassword" class="col-sm-4 col-form-label newPassLabel">Confirm Password</label>
									<div class="col-sm-6">
										<input type="password" class="form-control" id="inputPassword" placeholder="Confirm Password" minlength="8" required>
									</div>
								</div>
							</form>
						<h6><p>Password must contain at least 1 uppercase letter, 1 number, and one special char (! @ # $ % &)</p></h6>
					</div>
					<div class="modal-footer" style="background-color: rgb(199, 199, 201)">
						<button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-outline-primary" form="newPass">Submit</button>
					</div>
				</div>
			</div>
		</div>

				<!-- View Info Modal -->
		<div id="viewInfo" class="modal fade">
			<div class="modal-dialog modal-md" role="document">
				<div class="modal-content">
					<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Personal Information</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
					</div>
					<div class="modal-body">
						<p>Name</p>
						<p>Id</p>
						<p>Location</p>
					</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
				</div>
			</div>
		</div>
		<div id="UpdateDateLoc" class="modal fade">
			<div class="modal-dialog modal-md" role="document">
				<div class="modal-content">
					<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Justification/Comments</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
					</div>
					<div class="modal-body">
						<p>Justification:</p>
						<p>Comments:</p>
					</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
				</div>
			</div>
		</div>
		<div id="UpdateModule" class="modal fade">
			<div class="modal-dialog modal-md" role="document">
				<div class="modal-content">
					<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Justification/Comments</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
					</div>
					<div class="modal-body">
						<p>Module Name:</p>
						<p>Module Type:</p>
						<p>Module Scope:</p>
						<p>Training Mode:</p>
					</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
				</div>
			</div>
		</div>
		<div id="UpdateComments" class="modal fade">
			<div class="modal-dialog modal-md" role="document">
				<div class="modal-content">
					<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Justification/Comments</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
					</div>
					<div class="modal-body">
						<p>Justification:</p>
						<p>Comments:</p>
					</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
				</div>
			</div>
		</div>
		


		<div style="background-color: rgb(185, 184, 184)"><br></div>
			<footer class="footer" style="background-color:rgb(185, 184, 184); height: 40px">
				<div class="text-center">
						<p class="text-muted credit">Atos Syntel &copy; 2019 </p>
				</div>
			</footer>
	</body>

</html>