<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>Sign up form</h1>
	<c:if test="${not empty error}">
		<p>${error}</p>	
	</c:if>
	<form action="http://localhost:8080/Amazon/authentication/signUp" method="POST">
		<input type="hidden" name="key" value="true"/>
		<input type="hidden" name="userRole" value="client"/>
		<label for="userEmail">Email</label><br/><br/>
		<input type="email" name="userEmail" id="userEmail"/><br/><br/>
		<label for="userPassword">Password</label><br/><br/>
		<input type="password" name="userPassword" id="userPassword"/><br/><br/>
		<label for="userName">Full name</label><br/><br/>
		<input type="text" name="userName" id="userName"/><br/><br/>
		<label for="phoneNumber">Phone number</label><br/><br/>
		<input type="text" name="phoneNumber" id="phoneNumber"/><br/><br/>
		<label>Address: </label><br/><br/>
		<label for="address.city">City</label><br/><br/>
		<input type="text" name="clientAddress.city" id="address.city"/><br/><br/>
		<label for="address.street">Street</label><br/><br/>
		<input type="text" name="clientAddress.street" id="address.street"/><br/><br/>
		<label for="district">District</label><br/><br/>
		<input type="text" name="clientAddress.district" id="address.district"/><br/><br/>
		<label for="address.others">Others</label><br/><br/>
		<input type="text" name="clientAddress.others" id="address.others"/><br/><br/>
		<input type="submit" value="Sign up"/>
	</form>
</body>
</html>

































