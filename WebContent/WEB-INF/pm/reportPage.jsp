<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

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
    	<link href='<c:url value="/resources/css/front.css" />' rel="stylesheet">
		<script src="<c:url value="/resources/js/landing.js" />"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
	    <style>
	      .dropdown-item:hover {
	        background: grey;
	        font-color: black;
	      }
	    </style>
    
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
									<a  class="dropdown-item" href="signout">Sign Out</a>
							</div>
					</li>
				</ul>
			</div>
		</nav>
		<nav class="navbar collapse navbar-collapse navbar-lower navbar-expand-sm" id="navLower" style="background-color:rgb(51, 96, 223)">
			<div class="container offset-md-1">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
					<a class="nav-link active" href="home"><i class="fas fa-home" title="Home" style="font-size:25px; color:cornsilk"></i> <span class="sr-only">(current)</span></a>
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
		
		 <div class="col-lg-12" style="padding-top: 25px">
      <form id="chartSelect" class="col-lg-7 offset-lg-3">
        <div class="form-row">
          <div class="col">
            <label for="chartType">Chart Type</label>
            <select id="chartType" class="form-control">
              <option></option>
              <option id="bar" value="bar">Bar</option>
              <option id="hist" value="line">Line</option>
              <option id="pie" value="pie">Doughnut and Pie</option>
            </select>
          </div>
          <div class="col">
            <label for="startDate">Start Date</label>
            <input autofocus class="form-control" id="startDate" type="date" />
          </div>
          <div class="col">
            <label for="endDate">End Date</label>
            <input class="form-control" id="endDate" type="date" />
          </div>
          <div class="col-auto">
            <label class="col" for="submitSelect">&nbsp;</label>
            <button
              id="submitSelect"
              type="submit"
              class="btn btn-outline-secondary"
              form="chartSelect">Submit</button
            >
          </div>
        </div>
      </form>
    </div>

    <br />

    <div class="container col-lg-6">
      <canvas id="myChart" width="325" height="200"></canvas>
    </div>
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
						<p>Welcome, ${manager.first_name} &nbsp; ${pm.last_name} </p>
						<p>Id: ${manager.employee_id}</p>
						<p>Position: ${manager.job_title}</p>
					</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
				</div>
			</div>
		</div>
    <br />
    <footer class="footer">
      <div class="text-center">
        <p class="text-muted credit">Atos Syntel &copy; 2019 </p>
      </div>
    </footer>
    <script>
      //sets the end date to today's date by default on page load
      $(document).ready(function() {
        var now = new Date();
        var month = now.getMonth() + 1;
        var day = now.getDate();
        if (month < 10) month = "0" + month;
        if (day < 10) day = "0" + day;
        var today = now.getFullYear() + "-" + month + "-" + day;
        $("#endDate").val(today);
      });
    </script>

    <script>
      var config = {
        type: "bar",
        data: {
          labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
          datasets: [
            {
              label: "# of Votes",
              data: [12, 19, 3, 5, 2, 3],
              backgroundColor: [
                "rgba(255, 99, 132, 0.2)",
                "rgba(54, 162, 235, 0.2)",
                "rgba(255, 206, 86, 0.2)",
                "rgba(75, 192, 192, 0.2)",
                "rgba(153, 102, 255, 0.2)",
                "rgba(255, 159, 64, 0.2)",
              ],
              borderColor: [
                "rgba(255,99,132,1)",
                "rgba(54, 162, 235, 1)",
                "rgba(255, 206, 86, 1)",
                "rgba(75, 192, 192, 1)",
                "rgba(153, 102, 255, 1)",
                "rgba(255, 159, 64, 1)",
              ],
              borderWidth: 1,
            },
          ],
        },
        options: {
          scales: {
            yAxes: [
              {
                ticks: {
                  beginAtZero: true,
                },
              },
            ],
          },
        },
      }

      var ctx = document.getElementById("myChart").getContext("2d");
      var myChart = new Chart(ctx, config);

      $("#chartSelect").submit(function(e) {
        e.preventDefault();
        var e = document.getElementById("chartType");
        var strUser = e.options[e.selectedIndex].value;
        //alert(strUser);
        //var c = document.getElementById("myChart");
        var currType = myChart.config.type;
        //alert(currType);

        var ctx = document.getElementById("myChart").getContext("2d");

        if(strUser === "bar") {
          if (myChart) {
            myChart.destroy();
          }
          var temp = jQuery.extend(true, {}, config);
          temp.type = "bar";
          myChart = new Chart(ctx, temp);
        }
        
        else if (strUser == "line") {
          if (myChart) {
            myChart.destroy();
          }
          var temp = jQuery.extend(true, {}, config);
          temp.type = "line";
          myChart = new Chart(ctx, temp);
        }
        else if (strUser == "pie") {
          if (myChart) {
            myChart.destroy();
          }
          var temp = jQuery.extend(true, {}, config);
          temp.type = "doughnut";
          myChart = new Chart(ctx, temp);
        }
        else {
          //the blank chart select was chosen
          alert("Please choose a chart type");
        }
      });

    </script>
	</body>

</html>