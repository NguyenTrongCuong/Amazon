package main.model.shippingdetails;

import java.sql.Date;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import main.model.order.Bill;
import main.model.user.Address;
import main.model.user.User;

@Entity
public class ShippingDetails implements Persistable<Integer> {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int shippingId;
	private Date startDate;
	private Date endDate;
	private Address address;
	@OneToOne
	@JoinColumn(name="billId")
	private Bill bill;
	@ManyToOne
	@JoinColumn(name="userEmail")
	private User employee;
	@Transient
	private boolean isNew = true;
	
	public ShippingDetails() {}
	
	public ShippingDetails(Date startDate, Date endDate, Address address, User employee) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.employee = employee;
	}
	
	public int getShippingId() {
		return shippingId;
	}
	
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public User getEmployee() {
		return employee;
	}
	
	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public Integer getId() {
		return this.shippingId;
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




























































