package main.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import main.model.order.Bill;

@Entity
public class Client extends User {
	private String phoneNumber;
	@Embedded
	private Address clientAddress;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private List<Bill> bill = new ArrayList<Bill>();

	public Address getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(Address clientAddress) {
		this.clientAddress = clientAddress;
	}

	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	

}




































