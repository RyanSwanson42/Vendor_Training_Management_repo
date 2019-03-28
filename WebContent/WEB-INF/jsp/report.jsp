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

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
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
			height="30" /> <a class="navbar-brand" href="<c:url value="/dashboard" />"> <!--<b>Atos</b>Syntel-->
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
				<li class="nav-item"><a class="nav-link" href="">Run Report</a></li>
				<li class="nav-item"><a class="nav-link"
					href="vendormanagement/0">Vendor Management</a></li>
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
	<div style="width: 50%; height: 200px;">

		<canvas id=myChart title="HEllo"> </canvas>

		<button id="line"  type="button">Line</button>
		<button id="bar"  type="button">Bar</button>
		<button id="radar" type="button">Radar</button>

	</div>

	<script>
		var ctx = document.getElementById('myChart');

		var labels = new Array();
		var datalist = new Array();
		<c:forEach var="chartIndex" items="${SpocChartList}" varStatus="ChartCount" >
		labels.push("${chartIndex.getName()}");
		datalist.push(parseInt("${chartIndex.getAmount()}", 10));

		</c:forEach>

	var config =  {
			type : 'bar',
			data : {
				labels : labels,
				datasets : [ {
					label : '# of Votes',
					data : datalist,
					backgroundColor : [ 'rgba(255, 99, 132, 0.5)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 206, 86, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 159, 64, 0.2)' ],
					borderColor : [ 'rgba(255, 99, 132, 1)',
							'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)',
							'rgba(255, 159, 64, 1)' ],
					borderWidth : 3,

				} ]
			},
			options : {
				scales : {

					yAxes : [ {
						scaleLabel : {
							display : true,
							labelString : 'Training Request Processed'
						},
						barPercentage : 0.7,
						categoryPercentage : 1.0,
						maxBarThickness : 11,
						minBarLength : 5,
						gridLines : {
							offsetGridLines : true
						},
						ticks : {
							beginAtZero : true
						}
					} ],
					xAxes : [ {
						scaleLabel : {
							display : true,
							labelString : 'Spoc Names'
						}

					} ]
				},
				title : {
					display : true,
					position : 'top',
					text : 'Training Request Per Spoc',
					fontSize : 30,
					fontColor : 'maroon',
					fontStyle : 'bold'

				},
				legend : {
					display : true,
					position : 'right',
					boxWidth : 40,
					labels : {
						fontColor : 'rgb(255, 99, 132)'
					},
					animations : {
						duration : 1000,
						easing : 'easeOutQuart',

					}

				}
			}
		};
	var myChart = new Chart(ctx,config);
	
	$("line").click(function() {
	alert("hello");
	});
	</script>


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

</body>
</html>