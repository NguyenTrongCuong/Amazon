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
	<h1>Update Form</h1>
	<form action="http://localhost:8080/Amazon/employee/adminworks/updateProduct" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="key" value="true"/>
		<label for="productId">Product's id</label><br/><br/>
		<input type="text" name="productId" value="${product.productId}" id="productId" readonly/><br/><br/>
		<label for="productName">Product's name</label><br/><br/>
		<input type="text" name="productName" value="${product.productName}" id="productName"/><br/><br/>
		<label for="productType">Product's type</label><br/><br/>
		<input type="text" name="productType" value="${product.productType}" id="productType" readonly/><br/><br/>
		<label for="productCategory">Product's category</label><br/><br/>
		<input type="text" name="productCategory" value="${product.productCategory}" id="productCategory" readonly/><br/><br/>
		<label for="productPrice">Product's price</label><br/><br/>
		<input type="text" name="productPrice" value="${product.productPrice}" id="productPrice"/><br/><br/>
		<label for="image">Image</label><br/><br/>
		<input type="file" name="image" id="image"/><br/><br/>
		<label for="productQuantity">Product's quantity</label><br/><br/>
		<input type="text" name="productQuantity" value="${product.productQuantity}" id="productQuantity"/><br/><br/>
		<c:choose>
			<c:when test="${product.productType eq 'Book'}">
				<label for="author">Author</label><br/><br/>
				<input type="text" name="author" value="${product.author}" id="author"/><br/><br/>
				<label for="publisher">Publisher</label><br/><br/>
				<input type="text" name="publisher" value="${product.publisher}" id="publisher"/><br/><br/>
			</c:when>
			<c:when test="${product.productType eq 'GamingGear'}">
				<label for="brand">Brand</label><br/><br/>
				<input type="text" name="brand" value="${product.brand}" id="brand"/><br/><br/>
				<c:choose>
					<c:when test="${product.productCategory eq 'Mouse'}">
						<label for="dps">DPS</label><br/><br/>
						<input type="text" name="dps" value="${product.dps}" id="dps"/><br/><br/>
					</c:when>
					<c:when test="${product.productCategory eq 'Keyboard'}">
						<label for="keyAdventure">Key adventure</label><br/><br/>
						<input type="text" name="keyAdventure" value="${product.keyAdventure}" id="keyAdventure"/><br/><br/>
					</c:when>
				</c:choose>
			</c:when>
			<c:when test="${product.productType eq 'Food'}">
				<label for="quantityUnit">Product's unit</label><br/><br/>
				<input type="text" name="quantityUnit" value="${product.quantityUnit}" id="quantityUnit"/><br/><br/>
				<label for="origin">Origin</label><br/><br/>
				<input type="text" name="origin" value="${product.origin}" id="origin"/><br/><br/>
				<c:choose>
					<c:when test="${product.productCategory eq 'Meat'}">
						<label for="quality">Quality</label><br/><br/>
						<input type="text" name="quality" value="${product.quality}" id="quality"/><br/><br/>
					</c:when>
					<c:when test="${product.productCategory eq 'Milk'}">
						<label for="expiryDate">Expiry date</label><br/><br/>
						<input type="date" name="expiryDate" value="${product.expiryDate}" id="expiryDate"/><br/><br/>
					</c:when>
					<c:when test="${product.productCategory eq 'Vegetable'}">
						<label for="freshness">Fresh</label><br/><br/>
						<input type="text" name="freshness" value="${product.freshness}" id="freshness"/><br/><br/>
					</c:when>
				</c:choose>
			</c:when>
		</c:choose>
		<input type="submit" value="Update"/>
	</form>
</body>
</html>























































