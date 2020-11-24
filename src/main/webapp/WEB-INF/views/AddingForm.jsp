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
	<script type="text/javascript" src='<spring:url value="/employee/resources/js/AddProduct.js"/>'></script>	
</head>
<body>
	<h1>Adding Form</h1>
	<form action="http://localhost:8080/Amazon/employee/adminworks/addProduct" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="forAddingProduct" value="true"/>
		<label for="productName">Product's name</label><br/><br/>
		<input type="text" name="productName" id="productName"/><br/><br/>
		<label for="productPrice">Product's price</label><br/><br/>
		<input type="text" name="productPrice" id="productPrice"/><br/><br/>
		<label for="productQuantity">Product's quantity</label><br/><br/>
		<input type="text" name="productQuantity" id="productQuantity"/><br/><br/>
		<label for="image">Product's image</label><br/><br/>
		<input type="file" name="image" id="image"/><br/><br/>
		<label for="productCategory">Product's category</label><br/><br/>
		<input type="text" name="productCategory" id="productCategory"/><br/><br/>
		<label for="productType">Product's type: </label>
		<select name="productType" id="productType">
			<c:forEach var="ele" items="${productType}">
				<option value="${ele}">${ele}</option>
			</c:forEach>
		</select>
	</form><br/>
	<button id="check">Check</button>
	<button id="save">Save</button>
</body>
</html>























































