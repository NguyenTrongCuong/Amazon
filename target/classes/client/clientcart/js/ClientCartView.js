let cart = JSON.parse(localStorage.getItem("cart"));

$(document).ready(function(){
	if(cart.length == 0) {
		const header = $("<p>Your cart is empty :<</p>");
		$("#cartDetails").append(header);
	}
	else {
		const header = $("<p>ID Name Quantity Price</p>");
		$("#cartDetails").append(header);
		for(let i = 0; i < cart.length; ++i) {
			const element = $("<p id='" + i + "'>" 
							   + cart[i].productId
							   + " "
							   + cart[i].productName
							   + " <button onclick='plus(" + i + ")'>+</button> <input type='text' id='quantity"
							   + cart[i].productId
							   + "' value='" + cart[i].fakeQuantity
							   + "' readonly size='4'/> <button onclick='minus(" + i + ")'>-</button> <span id='price"
							   + cart[i].productId
							   + "'>"
							   + cart[i].productPrice
							   + "</span> <button onclick='removeProduct(" + cart[i].productId + ", " + i + ")'>Remove</button></p>");
			$("#cartDetails").append(element);
		}
		const payment = $("<button><a href='http://localhost:8080/Amazon/clientCart/doPayment'>Do payment</a></button>");
		$("#cartDetails").after(payment);
	}
});

function plus(index) {
	let quantity = parseInt($("#quantity" + cart[index].productId).val());
	let price = parseInt($("#price" + cart[index].productId).text());
	let actualPrice = cart[index].productPrice;
	if(quantity < cart[index].productQuantity) {
		$("#quantity" + cart[index].productId).val(quantity + 1);
		price += actualPrice;
		$("#price" + cart[index].productId).text(price);
		cart[index].fakeQuantity = quantity + 1;
		localStorage.setItem("cart", JSON.stringify(cart));
	}
}
function minus(index) {
	let quantity = parseInt($("#quantity" + cart[index].productId).val());
	let price = parseInt($("#price" + cart[index].productId).text());
	let actualPrice = cart[index].productPrice;
	if(quantity > 1) {
		$("#quantity" + cart[index].productId).val(quantity - 1);
		price -= actualPrice;
		$("#price" + cart[index].productId).text(price);
		cart[index].fakeQuantity = quantity - 1;
		localStorage.setItem("cart", JSON.stringify(cart));
	}
}

function removeProduct(productId, index) {
	const header = $("<p>Your cart is empty :<</p>");
	for(let i = 0; i < cart.length; ++i) {
		if(cart[i].productId == productId) {
			cart.splice(i, 1);
			break;
		}
	}
	localStorage.setItem("cart", JSON.stringify(cart));
	$("#" + index).remove();
	if(cart.length == 0) {
		$("#cartDetails").empty();
		$("#cartDetails").append(header);
	}
}








































































