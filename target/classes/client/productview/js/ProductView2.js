$(document).ready(function(){
	const categoryFilters = $("#categoryFilter").val();
	const productFilters = $("#productFilter").val();
	const arr1 = categoryFilters.trim().split("  ");
	const arr2 = productFilters.trim().split("  ");
	for(let i = 0; i < arr1.length; ++i) {
		$("[id='" + arr1[i] + "']").prop('checked', true);
	}
	for(let i = 0; i < arr2.length; ++i) {
		$("[id='" + arr2[i] + "']").prop('checked', true);
	}
});