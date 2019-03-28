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
<form:form action="../../updateNewDate">
		Start Date:<form:input path="request_start_date" /><br>
		End Date:<form:input path="request_end_date"/><br>
		Location: <form:input path="request_location"/><br>
		Timezone: <form:input path="request_time_zone"/><br>
		<form:button>Update</form:button>
	</form:form>
</body>
</html>