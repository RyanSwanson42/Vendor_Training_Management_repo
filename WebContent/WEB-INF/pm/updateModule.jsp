<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="../../updateNewModule">
		Module Name:<form:select path="request_training_module" >
					<form:option value="Java FSD"/>
		            <form:option value=".Net"/>
		            <form:option value="Cisco CCNA"/>
		            <form:option value="Azure"/>
		            <form:option value="Python"/>
		            <form:option value="Front End"/>
		            <form:option value="Mobile"/>
		            <form:option value="Other"/>
				</form:select><br>
		Module Type:<form:input path="request_training_type"/><br>
		Module Scope: <form:select path="request_training_module_scope">
		<form:option value="Spring"/>
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
		Training Mode: <form:select path="request_training_mode">
					<form:option value="Classroom"/>
		            <form:option value="eLearning"/>
		            <form:option value="Video"/>
		            <form:option value="Other"/>
		            </form:select>
		<br>
		<form:button>Update</form:button>
	</form:form>
</body>
</html>