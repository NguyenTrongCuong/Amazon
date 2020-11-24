package main.model.product;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Keyboard extends GamingGear {
	private String keyAdventure;
	
	public Keyboard() {}

	public Keyboard(String productName,
					String productType,
					int productQuantity,
					String productCategory,
					long productPrice,
					String imageLocation,
					MultipartFile image,
					String brand,
					String keyAdventure) {
		super(productName, productType, productQuantity, productCategory, productPrice, imageLocation, image, brand);
		this.keyAdventure = keyAdventure;
	}

	public String getKeyAdventure() {
		return keyAdventure;
	}

	public void setKeyAdventure(String keyAdventure) {
		this.keyAdventure = keyAdventure;
	}
	
	
}
