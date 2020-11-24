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
	<h1>Search Form</h1>
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
	<form action="http://localhost:8080/Amazon/employee/adminworks/findProductById" method="POST">
		<input type="hidden" name="key" value="true"/>
		<input type="hidden" name="destination" value="${destination}"/>
		<label for="productId">Product's id</label><br/><br/>
		<input type="text" name="productId" id="productId"><br/><br/>
		<input type="submit" value="Find"/>
	</form>
</body>
</html>