$(document).ready(function(){
	$("#add").click(function(){
		const product = {
			productId: parseInt($("#productId").text()),
			productName: $("#productName").text(),
			productPrice: parseInt($("#productPrice").text()),
			productType: $("#productType").text(),
			productCategory: $("#productCategory").text(),
			productQuantity: parseInt($("#productQuantity").text()),
			productImage: $("#productImage").val(),
			fakeQuantity: 1
		};
		let cart = JSON.parse(localStorage.getItem("cart"));
		cart.push(product);
		localStorage.setItem("cart", JSON.stringify(cart));
		alert("Added successfully");
	});
});