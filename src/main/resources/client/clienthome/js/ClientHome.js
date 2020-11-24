$(document).ready(function(){
	if(localStorage.getItem("cart") == null) {
		let arr = [];
		localStorage.setItem("cart", JSON.stringify(arr));
	}
	$("#keyword").keyup(function(){
		let content = $("#keyword").val();
		if(content.length == 0) {
			$("#searchResult").empty();
			return;
		}
		else {
			$.ajax({
				url: "http://localhost:8080/Amazon/search/findProduct",
				type: "POST",
				data: {
					keyword: content
				}, 
				success: function(data) {
					$("#searchResult").empty();
					let rs = data;
					if(rs.length == 0) {
						const element = $("<p>No results found</p>");
						$("#searchResult").append(element);
					}
					else {
						for(let i = 0; i < rs.length; ++i) {
							const element = $("<p><a href='http://localhost:8080/Amazon/clientService/getProductDetails?productId=" + rs[i].productId + "&productCategory=" + rs[i].productCategory + "'>" + rs[i].productName + "</a></p>");
							$("#searchResult").append(element);
						}
					}
				},
				error: function(xhr) {
					alert(xhr.status + " " + xhr.statusText);
				}
			});
		}
	});
});