package main.employee;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import main.employee.employeeauthentication.EmployeeAuthenticationService;
import main.model.cookie.CookieDetails;
import main.model.cookie.CookieService;
import main.model.user.Employee;

@Controller
public class DefaultEmployeePage {
	@Autowired
	private EmployeeAuthenticationService authenticationService;
	@Autowired
	private CookieService cookieService;
	
	
	@GetMapping("/employee")
	public String home(HttpServletRequest request, Model model) {
		HttpSession session = null;
		Cookie[] cookie = request.getCookies();
		if(cookie != null) {
			for(int i = 0; i < cookie.length; ++i) {
				if(cookie[i].getName().equals("token")) {
					CookieDetails temp = this.cookieService.getCookie(Integer.parseInt(cookie[i].getValue()));
					if(this.authenticationService.getEmployeeByEmail(temp.getUser().getUserEmail()).isEmpty()) {
						return "EmployeeLogIn";
					}
					else {
						Employee employee = this.authenticationService.getEmployeeByEmail(temp.getUser().getUserEmail()).get();
						model.addAttribute("account", employee);
						synchronized(session = request.getSession()) {
							session.setAttribute("account", employee);
						}
						return "Home";
					}
				}
			}
		}
		return "EmployeeLogIn";
	}
	
	@GetMapping("/backToHome")
	public String backToHome() {
		return "Home";
	}

}
