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
	<h1>History information</h1>
	<c:choose>
		<c:when test="${empty history}">
			<p>Empty</p>
		</c:when>
		<c:otherwise>
			<c:forEach var="ele" items="${history}">
				<span>ID            Created date            Total            Shipper's name</span><br/><br/>
				<span>${ele.billId}            ${ele.createdDate}            ${ele.billTotal}            ${ele.shippingDetails.employee.userName}</span><br/><br/>
				<span>Details: </span><br/><br/>
				<span>Product's ID            Product's name            Product's price            Product's type            Product's category</span><br/><br/>
				<c:forEach var="run" items="${ele.product}">
					<span>${run.productId}            ${run.productName}            ${run.productPrice}            ${run.productType}            ${run.productCategory}</span><br/><br/>
				</c:forEach>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>























































