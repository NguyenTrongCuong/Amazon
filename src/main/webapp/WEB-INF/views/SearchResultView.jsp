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
	<h1>Search result</h1>
	<c:choose>
		<c:when test="${empty searchResult}">
			<p>No results found</p>
		</c:when>
		<c:otherwise>
			<c:forEach var="ele" items="${searchResult}">
				<p><a href="http://localhost:8080/Amazon/clientService/getProductDetails?productId=${ele.productId}&productCategory=${ele.productCategory}">${ele.productId}</a> 
				   <a href="http://localhost:8080/Amazon/clientService/getProductDetails?productId=${ele.productId}&productCategory=${ele.productCategory}">${ele.productName}</a> 
				   ${ele.productPrice}</p>
				<p><img alt="productImage" src='<spring:url value="/pictures/${ele.imageLocation}"/>'/></p>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>























































