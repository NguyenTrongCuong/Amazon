package main.model.product;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Meat extends Food {
	private String quality;
	
	public Meat() {}

	public Meat(String productName,
				String productType,
				int productQuantity,
				String productCategory,
				long productPrice,
				String imageLocation,
				MultipartFile image,
				String origin,
				String quantityUnit,
				String quality) {
		super(productName, productType, productQuantity, productCategory, productPrice, imageLocation, image, origin, quantityUnit);
		this.quality = quality;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	

}

















































