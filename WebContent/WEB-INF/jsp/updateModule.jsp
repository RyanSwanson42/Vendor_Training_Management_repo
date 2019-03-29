<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
    
<!DOCTYPE html>
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
<h1></h1>
<form:form action="../../updateNewModule">
		<form:hidden path="training_request_id"/>
		Module Name:<form:select class="form-control" path="request_training_module" >
					<form:option value="Java FSD"/>
		            <form:option value=".Net"/>
		            <form:option value="Cisco CCNA"/>
		            <form:option value="Azure"/>
		            <form:option value="Python"/>
		            <form:option value="Front End"/>
		            <form:option value="Mobile"/>
		            <form:option value="Other"/>
				</form:select><br>
		Module Type:<form:input class="form-control" path="request_training_type"/><br>
		Module Scope: <form:select class="form-control" path="request_training_module_scope">
		<form:option class="form-control" value="Spring"/>
		            <form:option value="Spring MVC"/>
		            <form:option value="Spring Boot"/>  <!-- for javaFSD -->
		            <form:option value="Net Core"/>
		             <form:option value="Net Framework"/>
		            <form:option value="MVC5"/> <!-- Net -->
		            <form:option value="Azure"/>
		            <form:option value="Machine Learning"/> <!-- Azure -->
		             <form:option value="Numpy"/>
		            <form:option value="TensorFlow"/><!-- Python -->
		            <form:option value="Bootstrap"/> <!-- Front end -->
		            <form:option value="Spring Mobile"/> <!-- Mobile -->
		            <form:option value="Other"/>
		</form:select><br>
		Training Mode: <form:select class="form-control" path="request_training_mode">
					<form:option value="Classroom"/>
		            <form:option value="eLearning"/>
		            <form:option value="Video"/>
		            <form:option value="Other"/>
		            </form:select>
		<br>
		<form:button class="btn btn-outline-primary">Update</form:button>
	</form:form>
</body>
</html>