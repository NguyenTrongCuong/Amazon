package main.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import main.model.cookie.CookieDetails;
import main.model.shippingdetails.ShippingDetails;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	private String userEmail;
	private String userPassword;
	private String userRole;
	private String userName;
	@OneToOne(mappedBy="user", fetch=FetchType.LAZY)
	private CookieDetails cookie;

	public CookieDetails getCookie() {
		return cookie;
	}

	public void setCookie(CookieDetails cookie) {
		this.cookie = cookie;
	}

	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserRole() {
		return userRole;
	}
	
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
