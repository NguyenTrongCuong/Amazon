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
	<p>Hello ${account.userName}</p>
	<p><a href="http://localhost:8080/Amazon/employee/adminworks/getAddingForm">Add a product</a></p>
	<p><a href="http://localhost:8080/Amazon/employee/adminworks/getSearchForm?action=getorremove">Get a product</a></p>
	<p><a href="http://localhost:8080/Amazon/employee/adminworks/getSearchForm?action=update">Update a product</a></p>
</body>
</html>
