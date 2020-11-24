package main.model.product;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Vegetable extends Food {
	private String freshness;
	
	public Vegetable() {}

	public Vegetable(String productName,
					 String productType,
					 int productQuantity,
					 String productCategory,
					 long productPrice,
					 String imageLocation,
					 MultipartFile image,
					 String origin,
					 String quantityUnit,
					 String freshness) {
		super(productName, productType, productQuantity, productCategory, productPrice, imageLocation, image, origin, quantityUnit);
		this.freshness = freshness;
	}

	public String getFreshness() {
		return freshness;
	}

	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}
	
	

}
