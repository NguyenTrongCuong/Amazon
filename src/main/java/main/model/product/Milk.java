package main.model.product;

import java.sql.Date;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Milk extends Food {
	private Date expiryDate;
	
	public Milk() {}

	public Milk(String productName,
				String productType,
				int productQuantity,
				String productCategory,
				long productPrice,
				String imageLocation,
				MultipartFile image,
				String origin,
				String quantityUnit,
				Date expiryDate) {
		super(productName, productType, productQuantity, productCategory, productPrice, imageLocation, image, origin, quantityUnit);
		this.expiryDate = expiryDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	

}
