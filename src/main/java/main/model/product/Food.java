package main.model.product;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Food extends Product {
	private String origin;
	private String quantityUnit;
	
	public Food() {}

	public Food(String productName, 
			    String productType, 
			    int productQuantity, 
			    String productCategory,
			    long productPrice, 
			    String imageLocation, 
			    MultipartFile image,
			    String origin,
			    String quantityUnit) {
		super(productName, productType, productQuantity, productCategory, productPrice, imageLocation, image);
		this.origin = origin;
		this.quantityUnit = quantityUnit;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
}
