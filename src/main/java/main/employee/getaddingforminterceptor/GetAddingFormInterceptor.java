package main.employee.getaddingforminterceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GetAddingFormInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
		HttpSession session = null;
		synchronized(session = request.getSession()) {
			if(session.getAttribute("account") == null) {
				request.setAttribute("destination", "Home");
				request.setAttribute("error", "Please log in to continue");
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/EmployeeLogIn.jsp");
				view.forward(request, response);
				return false;
			}
			else return true;
		}
	}

}




















































