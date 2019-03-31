<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href='https://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet'>

<style>
.btn { /*dent around button*/
	display: inline-block;
	position: relative;
	width: 75%; height : 100%;
	background: #fff7f7;
	box-shadow: inset 0 0 4px rgba(155, 33, 0, 0.08);
	height: 100%;
}

.btn .fa { /*Button itself*/
	content: normal;
	width: 100%;
	height: 40px;
	background-image: -webkit-linear-gradient(#e8e8e8 0%, #d6d6d6 100%);
	background-image: linear-gradient(#e8e8e8 0%, #d6d6d6 100%);
	box-shadow: inset 4px 2px 4px rgba(255, 255, 255, 0.5), 0 2px 2px
		rgba(0, 0, 0, 0.19);
	border-bottom: solid 2px #b5b5b5;
}

.btn .fa .txt {
	width: inherit;
	height: inherit;
	margin-top: 13px;
	text-align: center;
	font-family: 'Ubuntu', sans-serif;
	color: #6495ED;
	
}

.btn .fa:active {
	background-image: -webkit-linear-gradient(#efefef 0%, #d6d6d6 100%);
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.5), 0 2px 2px
		rgba(0, 0, 0, 0.50);
	border-bottom: solid 2px #d8d8d8;
}
}
</style>
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
						style="float: none;"></i> ${username}
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
	<div class="container">
		<div class="row">
			<div id="buttDiv" class="col">
				<button id="TrPerSpoc" class="btn" type="button">
					<span class="fa"><div class="txt">Training Req.</div></span>
				</button>
			</div>
			<div id="buttDiv" class="col">
				<button id="numpar" class="btn" type="button">
					<span class="fa"><div class="txt">Participants</div></span>
				</button>
			</div>
			<div id="buttDiv" class="col">
				<button id="ReqPerDiv" class="btn" type="button">
					<span class="fa"><div class="txt">Executive Req.</div>.</span>
				</button>
			</div>
			<div id="buttDiv" class="col">
				<button id="StatusDiv" class="btn" type="button">
					<span class="fa"><div class="txt">Status</div></span>
				</button>
			</div>


		</div>
		<div class="row">

			<div id="chartDiv" class="col-10" style="display: block;">
				<canvas id=myChart > </canvas>
			</div>

			<div id="chartDiv2" class="col-10" style="display: none;">
				<canvas id=myChart2 ></canvas>
			</div>

			<div id="chartDiv3" class="col-10" style="display: none;">
				<canvas id=myChart3 ></canvas>
			</div>
			<div id="chartDiv4" class="col-10" style="display: none;">
				<canvas id=myChart4 ></canvas>
			</div>
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





	<script>
		$(document)
				.ready(
						function() {
							var a = [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
									'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ];
							var labels = new Array();
							var datalist = new Array();
							<c:forEach var="chartIndex" items="${SpocChartList}" varStatus="ChartCount" >
							labels.push("${chartIndex.getName()}");
							datalist.push(parseInt("${chartIndex.getAmount()}",
									10));
							</c:forEach>

							var backgroundColors1 = new Array();
							backgroundColors1 = createColors(datalist);
							var datalistDic = [];
							for (var i = 0; i < datalist.length; i++) {
								var tmp = datalist[i];
								var jsonObj = {
									label : labels[i],
									backgroundColor : backgroundColors1[i],
									data : [ tmp ]
								}
								datalistDic.push(jsonObj);
							}
							console.log()
							var ctx = document.getElementById('myChart');
							var config = {
								type : 'bar',
								data : {
									labels : [ 'Spoc Names' ],
									datasets : datalistDic

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
												display : false,
												labelString : 'Spoc Names'
											},

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
											text : labels,

										},
										animations : {
											duration : 1000,
											easing : 'easeOutQuart',

										}

									}
								}
							};

							var ctx2 = document.getElementById('myChart2');

							var Branch = new Array();
							var numParticipants = new Array();

							<c:forEach var="chartIndex2" items="${spcParticipants}" varStatus="ChartCount" >
							Branch.push("${chartIndex2.getName()}");
							numParticipants.push(parseInt(
									"${chartIndex2.getAmount()}", 10));
							</c:forEach>

							var backgroundColors2 = new Array();
							backgroundColors1 = createColors(numParticipants);
							var datalistDic = [];
							for (var i = 0; i < numParticipants.length; i++) {
								var tmp = numParticipants[i];
								var jsonObj = {
									label : Branch[i],
									backgroundColor : backgroundColors1[i],
									data : [ tmp ]
								}
								datalistDic.push(jsonObj);
							}
							//Second Configuration chart
							var config2 = {
								type : 'bar',
								data : {
									labels : [ 'Branch' ],
									datasets : datalistDic
								},
								options : {
									scales : {

										yAxes : [ {
											scaleLabel : {
												display : true,
												labelString : 'Overall Participants'
											},

											gridLines : {
												offsetGridLines : true
											},
											ticks : {
												beginAtZero : true
											}
										} ],
										xAxes : [ {
											scaleLabel : {
												display : false,
												labelString : 'Training Execution'
											}

										} ]
									},
									title : {
										display : true,
										position : 'top',
										text : 'Overall Participant Per Training Execution',
										fontSize : 30,
										fontColor : 'maroon',
										fontStyle : 'bold'

									},
									legend : {
										display : true,
										position : 'right',
										boxWidth : 40,

										animations : {
											duration : 1000,
											easing : 'linear',

										}

									}
								}
							};

							var ctx3 = document.getElementById('myChart3');

							var months = new Array();
							var Chart3IT = new Array();
							var Chart3VT = new Array();
							var Chart3DTT = new Array();

							<c:forEach var="ITIndex" items="${ITMonth}" varStatus="ChartCount" >
							months.push(a["${ITIndex.getMonth()}" - 1]);
							Chart3IT
									.push(parseInt("${ITIndex.getAmount()}", 10));
							</c:forEach>

							<c:forEach var="DTTIndex" items="${DTTMonth}" varStatus="ChartCount" >
							Chart3IT
							Chart3DTT.push(parseInt("${DTTIndex.getAmount()}",
									10));
							</c:forEach>

							<c:forEach var="VTIndex" items="${VTMonth}" varStatus="ChartCount" >
							Chart3VT
									.push(parseInt("${VTIndex.getAmount()}", 10));
							</c:forEach>

							var backgroundColor1 = createColors(new Array(3));
							//Third Configuration chart
							var Chart3ItData = {
								data : Chart3IT,
								label : 'IT',
								backgroundColor : backgroundColor1[0],
								fill : false

							};
							var Chart3DttData = {
								data : Chart3DTT,
								label : 'DTT',
								backgroundColor : backgroundColor1[1],
								fill : false

							};
							var Chart3VtData = {
								data : Chart3VT,
								label : 'VT',
								backgroundColor : backgroundColor1[2],
								fill : false

							};
							var config3 = {
								type : 'bar',
								data : {
									labels : months,
									datasets : [ Chart3ItData, Chart3DttData,
											Chart3VtData ]

								},
								options : {
									scales : {

										yAxes : [ {
											scaleLabel : {
												display : true,
												labelString : 'Training Request Processed'
											},
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
												labelString : 'Training Execution'
											},
											ticks : {
												autoSkip : false,
												beginAtZero : true
											}

										} ]
									},
									title : {
										display : true,
										position : 'top',
										text : 'Training Request Per Execution',
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

							//ending of Third configuration

							//BeginningOfFourth
							var ctx4 = document.getElementById('myChart4');
							var StatusLabels = new Array();
							var StatusData = new Array();

							<c:forEach var="chartIndex4" items="${Status}" varStatus="ChartCount" >
							StatusLabels.push("${chartIndex4.getStatus()}");
							StatusData.push("${chartIndex4.getSum()}");
							</c:forEach>
							var backgroundColor1 = createColors(new Array(3));
							var datalistDic = [];
							for (var i = 0; i < StatusData.length; i++) {
								var jsonObj = {
									label : StatusLabels[i],
									backgroundColor : backgroundColors1[i],
									data : [ StatusData[i] ]
								}
								datalistDic.push(jsonObj);
							}
							console.log(datalistDic);

							var config4 = {
								type : 'bar',
								data : {
									labels : [ "Status" ],
									datasets : datalistDic

								},
								options : {
									scales : {

										yAxes : [ {
											scaleLabel : {
												display : true,
												labelString : 'Training Request Processed'
											},
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
												labelString : 'Training Execution'
											},
											ticks : {
												autoSkip : false,
												beginAtZero : true
											}

										} ]
									},
									title : {
										display : true,
										position : 'top',
										text : 'Training Request Per Execution',
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
							}; //endingOfFourth

							var myChart = new Chart(ctx, config);
							var myChart2 = new Chart(ctx2, config2);
							var myChart3 = new Chart(ctx3, config3);
							var myChart4 = new Chart(ctx4, config4);

							$("#TrPerSpoc").click(function() {
								$("#chartDiv").css("display", "block");
								$("#chartDiv2").css("display", "none");
								$("#chartDiv3").css("display", "none");
								$("#chartDiv4").css("display", "none");

							});
							$("#numpar").click(function() {
								$("#chartDiv").css("display", "none");
								$("#chartDiv2").css("display", "block");
								$("#chartDiv3").css("display", "none");
								$("#chartDiv4").css("display", "none");

							});
							$("#ReqPerDiv").click(function() {
								$("#chartDiv").css("display", "none");
								$("#chartDiv2").css("display", "none");
								$("#chartDiv3").css("display", "block");
								$("#chartDiv4").css("display", "none");

							});
							$("#StatusDiv").click(function() {
								$("#chartDiv").css("display", "none");
								$("#chartDiv2").css("display", "none");
								$("#chartDiv3").css("display", "none");
								$("#chartDiv4").css("display", "block");

							});

						});
	</script>


	<script>
		function createColors(datalist) {

			var backgroundColorsArr = new Array();
			for (var i = 0; i < datalist.length; i++) {
				randomColor = Math.floor((Math.random() * 255) + 1);
				randomColor2 = Math.floor((Math.random() * 150) + 1);
				randomColor3 = Math.floor((Math.random() * 150) + 1);

				backgroundColorsArr.push('rgba(' + randomColor + ','
						+ randomColor2 + ',' + randomColor3 + ', .8)');

			}

			return backgroundColorsArr;
		}
	</script>
</body>
</html>