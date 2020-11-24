package main.model.product;


import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Intermediate {
	private int productId;
	private String productName;
	private String productType;
	private int productQuantity;
	private String productCategory;
	private long productPrice;
	private String imageLocation;
	private MultipartFile image;
	private String publisher;
	private String author;
	private String origin;
	private String quantityUnit;
	private String brand;
	private String keyAdventure;
	private String quality;
	private Date expiryDate;
	private String dps;
	private String freshness;
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getKeyAdventure() {
		return keyAdventure;
	}

	public void setKeyAdventure(String keyAdventure) {
		this.keyAdventure = keyAdventure;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getDps() {
		return dps;
	}

	public void setDps(String dps) {
		this.dps = dps;
	}

	public String getFreshness() {
		return freshness;
	}

	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public String getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public long getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getImageLocation() {
		return imageLocation;
	}
	
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	
	public MultipartFile getImage() {
		return image;
	}
	
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	

}
























































