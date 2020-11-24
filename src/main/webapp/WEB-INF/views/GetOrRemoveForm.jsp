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
	<script type="text/javascript" src='<spring:url value="/employee/remove/js/GetOrRemoveForm.js"/>'></script>
</head>
<body>
	<h1>Product information</h1>
	<p>ID: ${product.productId}</p>
	<p>Name: ${product.productName}</p>
	<p>Type: ${product.productType}</p>
	<p>Category: ${product.productCategory}</p>
	<p>Price: ${product.productPrice}</p>
	<p>Quantity: ${product.productQuantity}</p>
	<c:choose>
		<c:when test="${product.productType eq 'Book'}">
			<p>Author: ${product.author}</p>
			<p>Publisher: ${product.publisher}</p>
		</c:when>
		<c:when test="${product.productType eq 'GamingGear'}">
			<p>Brand: ${product.brand}</p>
			<c:choose>
				<c:when test="${product.productCategory eq 'Mouse'}">
					<p>DPS: ${product.dps}</p>
				</c:when>
				<c:when test="${product.productCategory eq 'Keyboard'}">
					<p>Key adventure: ${product.keyAdventure}</p>
				</c:when>
			</c:choose>
		</c:when>
		<c:when test="${product.productType eq 'Food'}">
			<p>Expiry date: ${product.quantityUnit}</p>
			<p>Origin: ${product.origin}</p>
			<c:choose>
				<c:when test="${product.productCategory eq 'Meat'}">
					<p>Meat quality: ${product.quality}</p>
				</c:when>
				<c:when test="${product.productCategory eq 'Milk'}">
					<p>Expiry date: ${product.expiryDate}</p>
				</c:when>
				<c:when test="${product.productCategory eq 'Vegetable'}">
					<p>Freshness: ${product.freshness}</p>
				</c:when>
			</c:choose>
		</c:when>
	</c:choose>
	<img src='<spring:url value="/employee/pictures/${product.imageLocation}"/>' alt="Product's image"/><br/><br/>
	<form action="http://localhost:8080/Amazon/employee/adminworks/removeProduct" method="POST">
		<input type="hidden" name="productId" value="${product.productId}"/>
	</form>
	<button id="remove">Remove</button>
</body>
</html>
































































