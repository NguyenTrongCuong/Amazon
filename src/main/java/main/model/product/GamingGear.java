package main.model.product;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class GamingGear extends Product {
	private String brand;
	
	public GamingGear() {}

	public GamingGear(String productName, 
			   		  String productType, 
			   		  int productQuantity, 
			   		  String productCategory,
			   		  long productPrice, 
			   		  String imageLocation, 
			   		  MultipartFile image,
			   		  String brand) {
		super(productName, productType, productQuantity, productCategory, productPrice, imageLocation, image);
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	

}
