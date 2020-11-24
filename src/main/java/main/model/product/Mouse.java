package main.model.product;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Mouse extends GamingGear {
	private String dps;
	
	public Mouse() {}

	public Mouse(String productName,
				 String productType,
				 int productQuantity,
				 String productCategory,
				 long productPrice,
				 String imageLocation,
				 MultipartFile image,
				 String brand,
				 String dps) {
		super(productName, productType, productQuantity, productCategory, productPrice, imageLocation, image, brand);
		this.dps = dps;
	}

	public String getDps() {
		return dps;
	}

	public void setDps(String dps) {
		this.dps = dps;
	}
	
	

}
