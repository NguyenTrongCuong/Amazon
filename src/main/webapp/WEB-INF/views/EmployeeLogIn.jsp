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
	<h1>Log In Form For Employee</h1>
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
	<form action="http://localhost:8080/Amazon/employee/authentication/login" method="POST">
		<c:choose>
			<c:when test="${empty destination}">
				<input type="hidden" name="forwardingPage" value="Home"/>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="forwardingPage" value="${destination}"/>
			</c:otherwise>
		</c:choose>
		<input type="hidden" name="forLogIn" value="true"/>
		<label for="email">Email</label><br/>
		<input type="email" name="email" id="email"/><br/>
		<label for="password">Password</label><br/>
		<input type="password" name="password" id="password"/><br/>
		<label for="rememberMe">Remember me: </label>
		<input type="checkbox" name="rememberMe" value="true" id="rememberMe"/><br/>
		<input type="submit" value="Log In"/>
	</form>
</body>
</html>





































