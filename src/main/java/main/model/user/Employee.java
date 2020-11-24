package main.model.user;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import main.model.shippingdetails.ShippingDetails;


@Entity
public class Employee extends User {
	private String position;
	@OneToMany(mappedBy="employee", fetch=FetchType.LAZY)
	private List<ShippingDetails> shippingDetails = new ArrayList<ShippingDetails>();
	
	public List<ShippingDetails> getShippingDetails() {
		return shippingDetails;
	}

	public void setShippingDetails(List<ShippingDetails> shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}






















































