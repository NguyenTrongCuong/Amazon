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
	<h1>Change password form</h1>
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
	<form action="http://localhost:8080/Amazon/authentication/changePassword" method="POST">
		<label for="oldPassword">Old password</label><br/><br/>
		<input type="password" name="oldPassword" id="oldPassword"/><br/><br/>
		<label for="newPassword1">New password</label><br/><br/>
		<input type="password" name="newPassword1" id="newPassword1"/><br/><br/>
		<label for="newPassword2">Reenter new password</label><br/><br/>
		<input type="password" name="newPassword2" id="newPassword2"/><br/><br/>
		<input type="submit" value="Change password"/>
	</form>
</body>
</html>























































