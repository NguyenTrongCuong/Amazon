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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src='<spring:url value="/search/js/ClientHome.js"/>'></script>
</head>
<body>
	<h1>Welcome</h1>
	<c:choose>
		<c:when test="${empty account}">
			<ul>
				<li><a href="http://localhost:8080/Amazon/authentication/getSignInForm">Sign in</a></li>
				<li><a href="http://localhost:8080/Amazon/authentication/getSignUpForm">Sign up</a></li>
				<li><a href="http://localhost:8080/Amazon/clientCart/getCartDetails">My cart</a></li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul>
				<li><a href="http://localhost:8080/Amazon/clientDetails/getOptions">${account.userName}</a></li>
				<li><a href="http://localhost:8080/Amazon/clientCart/getCartDetails">My cart</a></li>
				<li><a href="http://localhost:8080/Amazon/backToClientHome">Home</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
	<span>Search: </span>
	<input type="text" id="keyword"/>
	<button><a href="http://localhost:8080/Amazon/searchResult/getSearchResult">Go</a></button><br/>
	<div id="searchResult"></div>
	<c:forEach var="ele" items="${productType}">
		<p><a href="http://localhost:8080/Amazon/clientService/getProduct?productType=${ele}">${ele}</a></p>
	</c:forEach>
</body>
</html>

































