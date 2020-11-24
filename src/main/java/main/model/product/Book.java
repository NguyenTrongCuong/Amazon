package main.model.product;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Book extends Product {
	private String publisher;
	private String author;
	
	public Book() {}
	
	public Book(String productName, 
			    String productType, 
			    int productQuantity, 
			    String productCategory,
			    long productPrice, 
			    String imageLocation, 
			    MultipartFile image, 
			    String publisher, 
			    String author) {
		super(productName, productType, productQuantity, productCategory, productPrice, imageLocation, image);
		this.publisher = publisher;
		this.author = author;
	}

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
	
}




























































