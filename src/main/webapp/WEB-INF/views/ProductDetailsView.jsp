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
	<script type="text/javascript" src='<spring:url value="/productdetailsview/js/ProductDetailsView.js"/>'></script>
</head>
<body>
	<h1>Product information</h1>
	<p>ID: <span id="productId">${productDetails.productId}</span></p>
	<p>Name: <span id="productName">${productDetails.productName}</span></p>
	<p>Price: <span id="productPrice">${productDetails.productPrice}</span></p>
	<p>Type: <span id="productType">${productDetails.productType}</span></p>
	<p>Category: <span id="productCategory">${productDetails.productCategory}</span></p>
	<c:choose>
		<c:when test="${productDetails.productCategory eq 'Mouse'}">
			<p>DPS: ${productDetails.dps}</p>
		</c:when>
		<c:when test="${productDetails.productCategory eq 'Keyboard'}">
			<p>Key adventure: ${productDetails.keyAdventure}</p>
		</c:when>
		<c:when test="${productDetails.productCategory eq 'Meat'}">
			<p>Meat quality: ${productDetails.quality}</p>
			<p>Origin: ${productDetails.origin}</p>
			<p>Unit: ${productDetails.quantityUnit}</p>
		</c:when>
		<c:when test="${productDetails.productCategory eq 'Milk'}">
			<p>Expiry date: ${productDetails.expiryDate}</p>
			<p>Origin: ${productDetails.origin}</p>
			<p>Unit: ${productDetails.quantityUnit}</p>
		</c:when>
		<c:when test="${productDetails.productCategory eq 'Vegetable'}">
			<p>Freshness: ${productDetails.freshness}</p>
			<p>Origin: ${productDetails.origin}</p>
			<p>Unit: ${productDetails.quantityUnit}</p>
		</c:when>
		<c:when test="${productDetails.productCategory eq 'Book'}">
			<p>Author: ${productDetails.author}</p>
			<p>Publisher: ${productDetails.publisher}</p>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${productDetails.productQuantity != 0}">
			<p>Quantity: <span id="productQuantity">${productDetails.productQuantity}</span></p>
		</c:when>
		<c:otherwise>
			<p>Quantity: sold out</p>
		</c:otherwise>
	</c:choose>
	<p><img alt="productImage" src='<spring:url value="/pictures/${productDetails.imageLocation}"/>'/></p>
	<input type="hidden" id="productImage" value="${productDetails.imageLocation}"/>
	<c:if test="${productDetails.productQuantity != 0}">
		<button id="add">Add to my cart</button>
	</c:if>
</body>
</html>











































