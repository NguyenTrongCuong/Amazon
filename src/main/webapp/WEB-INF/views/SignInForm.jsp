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
	<h1>Sign in form</h1>
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
	<form action="http://localhost:8080/Amazon/authentication/signIn" method="POST">
		<c:choose>
			<c:when test="${empty destination}">
				<input type="hidden" name="forwardingPage" value="ClientHome"/>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="forwardingPage" value="${destination}"/>
			</c:otherwise>
		</c:choose>
		<input type="hidden" name="key" value="true"/>
		<label for="email">Email</label><br/><br/>
		<input type="email" name="email" id="email"/><br/><br/>
		<label for="password">Password</label><br/><br/>
		<input type="password" name="password" id="password"/><br/><br/>
		<label for="rememberMe">Remember me: </label>
		<input type="checkbox" name="rememberMe" value="true" id="rememberMe"/><br/><br/>
		<input type="submit" value="Sign in"/>
	</form>
</body>
</html>































































