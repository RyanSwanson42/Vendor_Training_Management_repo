<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Vendor TRM Team">

<title>Vendor TRM</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- FontAwesome-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<!-- Custom styles-->
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/vtm-modal.css"/>"
	rel="stylesheet">


<!-- Bootstrap core JavaScript -->
<script src="<c:url value="resources/vendor/jquery/jquery.min.js"/>"></script>
<script
	src="<c:url value="resources/vendor/bootstrap/js/bootstrap.bundle.min.js" /> "></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>


<!-- Local js scripts-->
<script src="<c:url value="resources/js/vtm.js" />"></script>
<script src="<c:url value="resources/js/trainingType.js" />"></script>

</head>
<body style="padding-top: 70px">

	<!-- Navigation -->
	<nav class="main-header navbar navbar-expand-lg navbar-dark fixed-top"
		style="background-color: #3c8dbc">
	<div class="container">
		<img src="<c:url value="resources/img/AtosSyntelLogoMedWhite.png" />"
			height="30" /> <a class="navbar-brand" href="<c:url value="/" />"> <!--<b>Atos</b>Syntel-->
			<i>Vendor <b>TRM</b>
		</i>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item py-1" style="padding-right: 5px"><input
					type="search" id="sb"
					style="color: white; border-radius: 15px; border: #fff 2px solid; background-color: #3c8dbc; padding-top: 2px; padding-bottom: 3px"
					required placeholder="  Filter..." /></li>
				<li class="nav-item"><a class="nav-link" href="#">Run
						Report</a></li>
				<li class="nav-item"><a class="nav-link" href="#" >Vendor
						Management</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fas fa-user-circle"
						style="float: none;"></i> ${userid}
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<span class="dropdown-item">Welcome, SPOC</span> <span
							class="dropdown-item">Your Vertical: ${uservert}</span>
						<div class="dropdown-divider"></div>
						<a onclick="location.href='/SpringApp/logout'"
							class="dropdown-item"> <b style="color: tomato">Logout</b>
						</a>
					</div></li>
			</ul>
		</div>
	</div>
	</nav>

	<!-- Vendor List Page -->
	<div class="vendor-list-pg">

		<input type="search" id="v-search" required placeholder="    Search" />

		<button type="button" class="btn btn-info" id="nv-btn">New
			Vendor</button>
		<br> <br> <br>
		<div class="container-fluid vm-grid-container">
			<c:forEach var="v" items="${vendorDetails}">
				<!-- Begin for loop -->
				<div class="row vm-row">
					<div class="col vm-col chkbox-col">
						<label class="chkbox-container"> <input type="checkbox">
							<span class="checkmark"></span>
						</label>
					</div>
					<div class="col vm-col">${v.vendor_name}</div>
					<div class="col vm-col">${v.vendor_phone}</div>
					<div class="col vm-col">${v.vendor_email}</div>
					<div class="col btn vm-col"
						style="border-radius: 0px; cursor: pointer;">
						Edit<span class="caret"></span>
					</div>
					<div class="dropdown">
						<button onclick="javascript:getTrainers(${v.vendor_id})"
							id="trainers-btn" class="col btn vm-col dropdown-toggle"
							type="button" data-toggle="dropdown"
							style="border-radius: 0px; cursor: pointer;">Trainers</button>
						<ul class="dropdown-menu">

							<li class="btn list-group-item d-flex trainer-list">
								<button class="btn btn-info"
									style="margin-left: 3px; margin-right: 3px;">Edit</button>
								<button class="btn btn-danger"
									style="margin-left: 3px; margin-right: 3px;">Delete</button>
							</li>

						</ul>
					</div>

					<div class="col btn vm-col"
						style="border-radius: 0px; cursor: pointer;">All Info</div>
					<div class="col btn vm-col-del"
						style="border-radius: 0px; cursor: pointer;">Delete</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- End Vendor List Page-->

	<!-- Add Vendor Page -->
	<div class="vendor-add-pg">
		<button type="button" class="btn btn-primary" id="return-btn">Return</button>
		&nbsp;
		<div class="container">
			<h3>Add a New Vendor Account</h3>
			<p>Fill out all pertinent information.</p>
			<form id="va-form">
				<div class="form-group">
					<label>Vendor Name</label> <input type="text" class="form-control"
						id="nameForm" placeholder="Enter Vendor name">
				</div>
				<div class="form-group">
					<label>Vendor Phone Number</label> <input type="text"
						class="form-control input-medium bfh-phone" id="phoneForm"
						data-format="+1 (ddd) ddd-dddd"
						placeholder="Enter Vendor phone number">
				</div>
				<div class="form-group">
					<label>Vendor Email Address</label> <input type="email"
						class="form-control" id="emailForm"
						placeholder="Enter Vendor email">
				</div>
				<div class="form-group">
					<label>Vendor City</label> <input type="text" class="form-control"
						id="cityForm" placeholder="Enter Vendor City">
				</div>
				<div class="form-group">
					<label>Vendor State</label> <input type="text" class="form-control"
						id="stateForm" placeholder="Enter Vendor State">
				</div>
				<div class="form-group">
					<label>Vendor Country</label> <input type="text"
						class="form-control" id="countryForm"
						placeholder="Enter Vendor Country">
				</div>
				<div class="form-group">
					<label>Vendor Zipcode</label> <input type="number"
						class="form-control" id="zipForm" placeholder="Enter Vendor Zip">
				</div>
				<div class="form-group">
					<label>Vendor Time Zone</label> <input type="text"
						class="form-control" id="timezoneForm"
						placeholder="Enter Vendor Time Zone">
				</div>
				<br>
			</form>
			<div style="text-align: center; margin-bottom: 2vh;">
				<button type="button" id="submit-btn" class="btn btn-success">Submit</button>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="py-0"
		style="background-color: #3c8dbc; width: 100%; bottom: 0; position: fixed;">
	<div class="container">
		<p class="m-0 text-left text-white"
			style="position: relative; top: 10px">Version 0.0.1</p>
		<p class="m-0 text-right text-white"
			style="position: relative; top: -14px">
			Copyright 2019</b>
		</p>
	</div>
	</div>
	</footer>

	<!-- Ryan AJAX to get all trainers -->
	<!-- <script>
    function getTrainers(id) {
        $.ajax({
           type: "POST",
           url : 'getTrainers',
           data: {id: id},
           success : function(data) {
        	   console.log('Data is: ' + data);
        	   // data should now contain... a list of jsons?
        	   for(var i = 0; i < data.length; i++){
                   var trainer = data[i];
                   
                   /* var tr='<tr><td>' + shortlistPT.vendor_name +  '</td><td>' + shortlistPT.vendor_phone +  '</td><td>' + shortlistPT.vendor_email +  '</td><td>' + shortlistPT.vendor_city +  '</td><td>' + shortlistPT.vendor_state +  '</td></tr>';
                   $('#table-body2').append(tr); */
                   
                   /* <li class="btn list-group-item d-flex trainer-list">
														<button class="btn btn-info"
															style="margin-left: 3px; margin-right: 3px;">Edit</button>
														<button class="btn btn-danger"
															style="margin-left: 3px; margin-right: 3px;">Delete</button>
													</li> */
                   
                   var newRow = '<li class="btn list-group-item d-flex trainer-list">' +
                 
                   //console.log(trainerList.vendor_trainer_name);                 
        	   }
        	   
           },
           error: function(XMLHttpRequest, textStatus, errorThrown) {
               alert("Status: " + textStatus); alert("Error: " + errorThrown);
           }
        });
    }
	</script>
 -->
</body>
</html>