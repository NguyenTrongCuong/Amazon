package main.client;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import main.model.cookie.CookieDetails;
import main.model.cookie.CookieService;
import main.model.product.repository.ProductService;
import main.model.user.Client;
import main.model.user.userrepository.UserService;

@Controller
public class DefaultClientController {
	@Autowired
	private UserService service;
	@Autowired
	private CookieService cookieService;
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("productType")
	public Object[] getProductType() {
		return this.productService.getProductType();
	}
	
	@GetMapping("/")
	public String home(HttpServletRequest request, Model model) {
		HttpSession session = null;
		Cookie[] cookie = request.getCookies();
		if(cookie != null) {
			for(int i = 0; i < cookie.length; ++i) {
				if(cookie[i].getName().equals("token")) {
					CookieDetails temp = this.cookieService.getCookie(Integer.parseInt(cookie[i].getValue()));
					Client client = (Client) this.service.getClientByEmail(temp.getUser().getUserEmail()).get();
					model.addAttribute("account", client);
					synchronized(session = request.getSession()) {
						session.setAttribute("account", client);
					}
					break;
				}
			}
		}
		return "ClientHome";
	}
	
	@GetMapping("/backToClientHome")
	public String backToHome() {
		return "ClientHome";
	}
	
}
































