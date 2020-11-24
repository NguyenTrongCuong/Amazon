$(document).ready(function(){
	let cart = JSON.parse(localStorage.getItem("cart"));
	let total = 0;
	let sum = 0;
	let id = "", quantity = "";	
	const header = ("<p>ID Name Type Category Price/product Quantity Sum</p>");
	$("#cartDetails").append(header);
	for(let i = 0; i < cart.length; ++i) {
		id += cart[i].productId;
		quantity += cart[i].fakeQuantity;
		if(i <= cart.length - 2) {
			id += ", ";
			quantity += ", ";
		}
		total += cart[i].productPrice * cart[i].fakeQuantity;
		sum = cart[i].productPrice * cart[i].fakeQuantity;
		const element = $("<p>"
					      + cart[i].productId
					      + " "
					      + cart[i].productName
					      + " "
					      + cart[i].productType
					      + " "
					      + cart[i].productCategory
					      + " "
					      + cart[i].productPrice
					      + " "
					      + cart[i].fakeQuantity
					      + " "
					      + sum
					      + "</p>");
		$("#cartDetails").append(element);
	}
	const temp = $("<p>Total: " + total + "</p>");
	$("#cartDetails").append(temp);
	const cancel = $("<button><a href='http://localhost:8080/Amazon/backToClientHome'>Cancel</a></button>");
	const accept = $("<button><a href='http://localhost:8080/Amazon/clientCart/processPayment?id=" + id + "&quantity=" + quantity + "&total=" + total + "'>Accept</a></button>");
	$("#cartDetails").after(accept);
	$("#cartDetails").after(cancel);
	
});