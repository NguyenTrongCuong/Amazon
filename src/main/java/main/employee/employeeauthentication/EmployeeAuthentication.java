package main.employee.employeeauthentication;


import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.model.cookie.CookieDetails;
import main.model.cookie.CookieService;
import main.model.user.Employee;

@Controller
@RequestMapping("/authentication")
public class EmployeeAuthentication {
	@Autowired
	private EmployeeAuthenticationService authenticationService;
	@Autowired
	private CookieService cookieService; 
	
	@PostMapping("/login")
	public String logIn(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = null;
		Employee employee = this.authenticationService.getEmployee(request.getParameter("email"), request.getParameter("password"));
		if(employee == null) {
			model.addAttribute("error", "Email or password is incorrect, please try again");
			return "EmployeeLogIn";
		}
		else {
			if(request.getParameter("rememberMe") != null) {
				CookieDetails cookie = employee.getCookie();
				if(cookie != null) {
					this.cookieService.deleteCookie(cookie);
				}
				CookieDetails token = new CookieDetails();
				Date startDate = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 7);
				Date endDate = calendar.getTime();
				token.setUser(employee);
				token.setStartDate(startDate);
				token.setEndDate(endDate);
				Cookie responseCookie = new Cookie("token", Integer.toString(this.cookieService.addCookie(token).getCookieId()));
				responseCookie.setMaxAge(604800);
				responseCookie.setPath("/Amazon/employee");
				response.addCookie(responseCookie);
			}
			model.addAttribute("account", employee);
			synchronized(session = request.getSession()) {
				session.setAttribute("account", employee);
			}
		}
		return request.getParameter("forwardingPage");
	}

}










































