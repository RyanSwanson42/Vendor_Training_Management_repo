<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Page</title>
<!--Made with love by Mutiullah Samim -->
<!--Bootsrap 4 CDN-->
<link href="resources/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">
	
<!--Fontawesome CDN-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
	
<!--Custom styles-->
<link rel="stylesheet" type="text/css" href="resources/css/loginStyle.css">
<script src="resources/vendor/jquery/jquery.js"></script>

</head>
<script>
function Validation(){
 var name = 'loginerror';
 var regexS = "/"+name;
 var regex = new RegExp( regexS );
 var results = regex.exec( window.location.href );
 if( results != null ){
   //here you don't have login errors
      alert("Wrong username and/or password, please try again.");
 }
   //here you have login error
 function ValidationCheck(){
	 var name = 'restricted';
	 var regexS = "/"+name;
	 var regex = new RegExp( regexS );
	 var results = regex.exec( window.location.href );
	 if( results != null ){
	   //here you don't have login errors
	      alert("Access Restricted.");
	 }     
}
</script>
<body>
        <div class="logo-placement"><img class="Logo-size" src="<c:url value="resources/img/AtosSyntelLogoLargeBlue.png" />"></div>

    <div class="container">

        <div class="d-flex justify-content-center h-100">
            <div class="card">
                <div class="card-header">
                    <center>
                        <h3>TRM Sign In</h3>
                    </center>
                </div>
                <div class="card-body">
                    <form action ="login">
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-user"></i></span>
                            </div>
                            <input type="text" name="un" class="form-control" placeholder="username" required>

                        </div>
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="password" name="up" class="form-control" placeholder="password" required>
                        </div>
                        <div class="row align-items-center remember">
                            <input type="checkbox">Remember Me
                        </div>
                        <div class="form-group">
                            <input type="submit" id="submit" value="Login" class="btn float-right login_btn">
                        </div>
                        <script>
                        	Validation();
                        </script>
                    </form>
                </div>
                <div class="card-footer">
                    <div class="d-flex justify-content-center">
                        <a href="#">Forgot your password?</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>