package main.model.order;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import main.model.product.Product;
import main.model.shippingdetails.ShippingDetails;
import main.model.user.Client;

@Entity
public class Bill implements Persistable<Integer> {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int billId;
	private Date createdDate;
	private long billTotal;
	@ManyToOne
	@JoinColumn(name="clientEmail")
	private Client client;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Product_Bill",
			   joinColumns=@JoinColumn(name="billId"),
			   inverseJoinColumns=@JoinColumn(name="productId"))
	private List<Product> product = new ArrayList<Product>();
	@OneToOne(mappedBy="bill")
	private ShippingDetails shippingDetails;
	@Transient
	private boolean isNew = true;
	
	public Bill() {}
	
	public Bill(Date createdDate, long billTotal, Client client, List<Product> product) {
		this.createdDate = createdDate;
		this.billTotal = billTotal;
		this.client = client;
		this.product = product;
	}
	
	public int getBillId() {
		return billId;
	}
	
	public void setBillId(int billId) {
		this.billId = billId;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public long getBillTotal() {
		return billTotal;
	}
	
	public void setBillTotal(long billTotal) {
		this.billTotal = billTotal;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Product> getProduct() {
		return product;
	}
	
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	public ShippingDetails getShippingDetails() {
		return shippingDetails;
	}
	
	public void setShippingDetails(ShippingDetails shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	public Integer getId() {
		return this.billId;
	}

	public boolean isNew() {
		return this.isNew;
	}
	
	@PrePersist
	@PostLoad
	public void markNotNew() {
		this.isNew = false;
	}
	
	
	
	
	

}











































