package main.model.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;
import org.springframework.web.multipart.MultipartFile;

import main.model.order.Bill;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Product implements Persistable<Integer> {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	private String productName;
	private String productType;
	private int productQuantity;
	private String productCategory;
	private long productPrice;
	private String imageLocation;
	@Transient
	private MultipartFile image;
	@Transient
	private boolean isNew = true;
	@ManyToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<Bill> bill = new ArrayList<Bill>();
	
	public Product() {}

	public Product(String productName, 
				   String productType, 
				   int productQuantity, 
				   String productCategory,
				   long productPrice, 
				   String imageLocation, 
				   MultipartFile image) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.productQuantity = productQuantity;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.imageLocation = imageLocation;
		this.image = image;
	}
	
	public Product(String productName, 
			       String productType, 
			       int productQuantity, 
			       String productCategory,
			       long productPrice, 
			       String imageLocation,
			       int productId) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.productQuantity = productQuantity;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.imageLocation = imageLocation;
		this.productId = productId;
	}


	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
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

	public Integer getId() {
		return this.productId;
	}

	public boolean isNew() {
		return this.isNew;
	}
	
	@PrePersist
	@PostLoad
	public void markNotNew() {
		this.isNew = false;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Product product = (Product) o;
		if(this.getProductId() == product.getProductId()) {
			return true;
		}
		else return false;
	}
	
	@Override
	public int hashCode() {
		return Integer.toString(this.getProductId()).hashCode();
	}
	
}

























































