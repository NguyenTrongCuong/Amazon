package main.model.cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.user.Client;

@Service
public class CookieService {
	@Autowired
	private CookieRepository service;
	
	public CookieDetails getCookie(int cookieId) {
		return this.service.findCookieDetailsByCookieId(cookieId);
	}
	
	public void deleteCookie(CookieDetails cookie) {
		this.service.delete(cookie);
	}
	
	public CookieDetails addCookie(CookieDetails cookie) {
		return this.service.save(cookie);
	}
	

}
