$(document).ready(function(){
	let cart = JSON.parse(localStorage.getItem("cart"));
	cart = [];
	localStorage.setItem("cart", JSON.stringify(cart));
});