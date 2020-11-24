$(document).ready(function(){
	$("#remove").click(function(){
		const rs = confirm("Are u sure to remove this product ?");
		if(rs == true) {
			$("form").submit();
		}
	});
});