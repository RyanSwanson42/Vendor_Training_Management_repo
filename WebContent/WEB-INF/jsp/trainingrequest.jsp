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
		
		<script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
		<link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/js/bootstrap4-toggle.min.js"></script>
		
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    	<link href='<c:url value="/resources/css/temp.css" />' rel="stylesheet">
		<script src="<c:url value="/resources/js/landing.js" />"></script>
		<script>
		$(document).ready(function () {
		    $("#myForm").submit(function () {
		        $(".mySubmit").attr("disabled", true);
		    });
		});
		</script>
</head>
<body>
	<h1>New Training Request:</h1>
	<form action="trainingrequest" id="myForm" onsubmit="submit.disabled = true; return true;">
	   <!-- id="exampleFormControlSelect1" -->
	   
	   		 <div class="container">     
		         <label for="trainingModule" ><b>Training Module</b></label>
		          <select name = "trainingModule" >
		            <option>Java FSD</option>
		            <option>.Net</option>
		            <option>Cisco CCNA</option>
		            <option>Azure</option>
		            <option>Python</option>
		            <option>Front End</option>
		            <option>Mobile</option>
		            <option>Other</option>
		          </select>
		   </div>
		   <div class="container">     
		         <label for="trainingType" ><b>Training Type</b></label>
		          <select name = "trainingType" >
		            <option>IT</option>
		            <option>VTT</option>
		            <option>DT</option>
		            
		          </select>
		   </div>
		   
		    <div class="container">     
		         <label for="trainingModuleScope" ><b>Training Mode</b></label>
		          <select name = "trainingModuleScope" >
		            <option>Spring</option>
		            <option>Spring MVC</option>
		            <option>Spring Boot</option>  <!-- for javaFSD -->
		            <option>Net Core</option>
		             <option>Net Framework</option>
		            <option>MVC5</option> <!-- Net -->
		            <option>Azure</option>
		            <option>Machine Learning</option> <!-- Azure -->
		             <option>Numpy</option>
		            <option>TensorFlow</option><!-- Python -->
		            <option>Bootstrap</option> <!-- Front end -->
		            <option>Spring Mobile</option> <!-- Mobile -->
		            <option>Other</option>
		          </select>
		   </div>
		   
	      <div class="container">     
		         <label for="trainingModuleMode" ><b>Training Module Mode</b></label>
		          <select name = "trainingModuleMode" >
		            <option>Classroom</option>
		            <option>eLearning</option>
		            <option>Video</option>
		            <option>Other</option>
		          </select>
		   </div>
	      
	      
	      <label for="startDate"><b>Start Date</b></label> 
	      <input type="date" placeholder="Enter StartDate" name="startDate" required><br>
	      
	      <label for="endDate"><b>End Date</b></label> 
	      <input type="date" placeholder="Enter EndDate" name="endDate" required ><br>
	      
	      <label for="spoc"><b>SPOC</b></label> 
	      <input type="text" placeholder="Spoc - Optional" name="spoc" value = "-1" ><br>
	      
	      <label for="participants"><b># Participants</b></label> 
	      <input type="text" placeholder="Numer Participants" name="participants" required><br>
	      
	      <label for="justification"><b>Justification</b></label> 
	      <input type="text" placeholder="Justification" name="justification" required> <br>
	   
	      
	      <button id="mySubmit" type="submit" name="submit">Request Training</button>
	      
	    </div>
	  </form>
</body>
</html>