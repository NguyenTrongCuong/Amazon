$(document).ready(function(){
	$("#check").click(function(){
		const type = $("#productType").val();
		const category = $("#productCategory").val();
		const button = $("<button onclick='save()'>Save</button>");
		if(type == "GamingGear") {
			const brandLabel = $("<br/><br/><label for='brand'>Brand</label><br/><br/>");
			const brand = $("<input type='text' name='brand' id='brand'/><br/><br/>");
			if(category == "Mouse") {
				const dpsLabel = $("<label for='dps'>Dps</label><br/><br/>");
				const dps = $("<input type='text' name='dps' id='dps'/><br/><br/>");
				$("#productType").after(brandLabel, brand, dpsLabel, dps);
			}
			else if(category == "Keyboard") {
				const keyAdventureLabel = $("<label for='keyAdventure'>Key Adventure</label><br/><br/>");
				const keyAdventure = $("<input type='text' name='keyAdventure' id='keyAdventure'/><br/><br/>");
				$("#productType").after(brandLabel, brand, keyAdventureLabel, keyAdventure);
			}
			else {
				const errorWarning = $("<br/><br/><span>Invalid category, please try again</span>");
				$("#image").after(errorWarning);
			}
		}
		else if(type == "Food") {
			const originLabel = $("<br/><br/><label for='origin'>Origin</label><br/><br/>");
			const origin = $("<input type='text' name='origin' id='origin'/><br/><br/>");
			const quantityUnitLabel = $("<label for='quantityUnit'>Quantity unit</label><br/><br/>");
			const quantityUnit = $("<input type='text' name='quantityUnit' id='quantityUnit'/><br/><br/>");
			if(category == "Meat") {
				const qualityLabel = $("<label for='quality'>Quality</label><br/><br/>");
				const quality = $("<input type='text' name='quality' id='quality'/><br/><br/>");
				$("#productType").after(originLabel, origin, quantityUnitLabel, quantityUnit, qualityLabel, quality);
			}
			else if(category == "Milk") {
				const expiryDateLabel = $("<label for='expiryDate'>Expiry date</label><br/><br/>");
				const expiryDate = $("<input type='date' name='expiryDate' id='expiryDate'/><br/><br/>");
				$("#productType").after(originLabel, origin, quantityUnitLabel, quantityUnit, expiryDateLabel, expiryDate);
			}
			else if(category == "Vegetable") {
				const freshLabel = $("<label for='fresh'>Freshness</label><br/><br/>");
				const fresh = $("<input type='text' name='fresh' id='fresh'/><br/><br/>");
				$("#productType").after(originLabel, origin, quantityUnitLabel, quantityUnit, freshLabel, fresh);
			}
			else {
				const errorWarning = $("<br/><br/><span>Invalid category, please try again</span>");
				$("#image").after(errorWarning);
			}
		}
		else {
			const authorLabel = $("<br/><br/><label for='author'>Author</label><br/><br/>");
			const author = $("<input type='text' name='author' id='author'/><br/><br/>");
			const publisherLabel = $("<label for='publisher'>Publisher</label><br/><br/>");
			const publisher = $("<input type='text' name='publisher' id='publisher'/><br/><br/>");
			$("#productType").after(authorLabel, author, publisherLabel, publisher);
		}
		$("#check").remove();
	});
	$("#save").click(function(){
		$("form").submit();
	});
});




















































