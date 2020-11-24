package main.client.clientauthentication;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.model.cookie.CookieDetails;
import main.model.cookie.CookieService;
import main.model.user.Client;
import main.model.user.Employee;
import main.model.user.userrepository.UserService;

@Controller
@RequestMapping("/authentication")
public class ClientAuthenticationController {
	@Autowired
	private UserService service;
	@Autowired
	private CookieService cookieService;
	
	@GetMapping("/getSignUpForm")
	public String getSignUpForm() {
		return "SignUpForm";
	}
	
	@PostMapping("/signUp")
	public String signUp(Client client, Model model) {
		if(this.service.verifyUserEmail(client.getUserEmail())) {
			model.addAttribute("error", "That email has been used, please choose another one");
			return "SignUpForm";
		}
		else {
			this.service.saveUser(client);
		}
		return "SignUpDone";
	}
	
	@GetMapping("/getSignInForm")
	public String getSignInForm(Model model) {
		model.addAttribute("destination", "redirect:/backToClientHome");
		return "SignInForm";
	}
	
	@PostMapping("/signIn")
	public String signIn(@RequestParam String email, @RequestParam String password, HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = null;
		Client client = this.service.getClient(email, password);
		if(client == null) {
			model.addAttribute("error", "Email or password is incorrect, please try again");
			model.addAttribute("destination", request.getParameter("forwardingPage"));
			return "SignInForm";
		}
		else {
			if(request.getParameter("rememberMe") != null) {
				CookieDetails cookie = client.getCookie();
				if(cookie != null) {
					this.cookieService.deleteCookie(cookie);
				}
				CookieDetails token = new CookieDetails();
				Date startDate = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 7);
				Date endDate = calendar.getTime();
				token.setUser(client);
				token.setStartDate(startDate);
				token.setEndDate(endDate);
				Cookie responseCookie = new Cookie("token", Integer.toString(this.cookieService.addCookie(token).getCookieId()));
				responseCookie.setMaxAge(604800);
				responseCookie.setPath("/Amazon");
				response.addCookie(responseCookie);
			}
			model.addAttribute("account", client);
			synchronized(session = request.getSession()) {
				session.setAttribute("account", client);
			}
		}
		return request.getParameter("forwardingPage");
	}
	
	@GetMapping("/getChangePasswordForm")
	public String getChangePasswordForm() {
		return "ChangePasswordForm";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam("oldPassword") String oldPassword,
								 @RequestParam("newPassword1") String newPassword1,
								 @RequestParam("newPassword2") String newPassword2,
								 HttpServletRequest request, 
								 Model model) {
		HttpSession session = null;
		Client client = null;
		synchronized(session = request.getSession()) {
			client = (Client) session.getAttribute("account");
		}
		if(!client.getUserPassword().equals(oldPassword)) {
			model.addAttribute("error", "Old password is incorrect, please try again");
			return "ChangePasswordForm";
		}
		if(!newPassword1.equals(newPassword2)) {
			model.addAttribute("error", "The two new passwords do not match, please try again");
			return "ChangePasswordForm";
		}
		client.setUserPassword(newPassword1);
		synchronized(session = request.getSession()) {
			session.setAttribute("account", client);
		}
		this.service.saveUser(client);
		return "ChangePasswordView";
	}
	
	@GetMapping("/logOut")
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		synchronized(session = request.getSession()) {
			session.invalidate();
			session = request.getSession(false);
		}
		Cookie[] cookie = request.getCookies();
		if(cookie != null) {
			for(Cookie ele : cookie) {
				if(ele.getName().equals("token")) {
					Cookie temp = new Cookie("token", "");
					temp.setMaxAge(0);
					temp.setPath("/Amazon");
					response.addCookie(temp);
					break;
				}
			}
		}
		return "redirect:/backToClientHome";
	}

}


























































