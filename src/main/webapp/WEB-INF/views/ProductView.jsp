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
	<h1>Product list</h1>
	<p>Filter</p>
	<form action="getSortedProduct" method="POST">
		<input type="hidden" name="key" value="true"/>
		<input type="hidden" name="productType" value="${productType}"/>
		<label>Sorted by price: </label>
		<select name="sortOption">
			<option value="None">None</option>
			<option value="High to low">High to low</option>
			<option value="Low to high">Low to high</option>
		</select><br/>
		<label>Category: </label>
		<c:forEach var="ele" items="${sessionScope.productCategory}">
			<input type="checkbox" name="categoryOption" value="${ele}" id="${ele}"/>
			<label>${ele}</label>
		</c:forEach><br/>
		<c:choose>
			<c:when test="${productType eq 'GamingGear'}">
				<label>Brand: </label>
				<c:forEach var="ele" items="${sessionScope.brand}">
					<input type="checkbox" name="brandOption" value="${ele}" id="${ele}"/>
					<label>${ele}</label>
				</c:forEach><br/><br/>
			</c:when>
			<c:when test="${productType eq 'Food'}">
				<label>Origin: </label>
				<c:forEach var="ele" items="${sessionScope.origin}">
					<input type="checkbox" name="originOption" value="${ele}" id="${ele}"/>
					<label>${ele}</label>
				</c:forEach><br/><br/>
			</c:when>
			<c:when test="${productType eq 'Book'}">
				<label>Author: </label>
				<c:forEach var="ele" items="${sessionScope.author}">
					<input type="checkbox" name="authorOption" value="${ele}" id="${ele}"/>
					<label>${ele}</label>
				</c:forEach><br/>
				<label>Publisher: </label>
				<c:forEach var="ele" items="${sessionScope.publisher}">
					<input type="checkbox" name="publisherOption" value="${ele}" id="${ele}"/>
					<label>${ele}</label>
				</c:forEach><br/><br/>
			</c:when>
		</c:choose>
		<input type="submit" value="Go"/><br/><br/>
	</form>
	<c:forEach var="ele" items="${productlist}">
		<p><a href="http://localhost:8080/Amazon/clientService/getProductDetails?productId=${ele.productId}&productCategory=${ele.productCategory}">${ele.productId}</a>
		   <a href="http://localhost:8080/Amazon/clientService/getProductDetails?productId=${ele.productId}&productCategory=${ele.productCategory}">${ele.productName}</a>
		   ${ele.productPrice}</p>
		<p><img src='<spring:url value="/pictures/${ele.imageLocation}"/>'/></p>
	</c:forEach>
	<c:if test="${pageNumber < totalPages}">
		<button><a href="http://localhost:8080/Amazon/clientService/getNextPage?productType=${productType}&nextOrPrevious=next">Next</a></button>
	</c:if>
	<c:if test="${pageNumber > 1}">
		<button><a href="http://localhost:8080/Amazon/clientService/getNextPage?productType=${productType}&nextOrPrevious=previous">Previous</a></button>
	</c:if>
</body>
</html>











































