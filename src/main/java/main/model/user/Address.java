package main.model.user;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String street;
	private String district;
	private String others;
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getOthers() {
		return others;
	}
	
	public void setOthers(String others) {
		this.others = others;
	}
	
}
