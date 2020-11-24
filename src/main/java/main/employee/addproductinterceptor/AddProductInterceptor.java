package main.employee.addproductinterceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AddProductInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
		if(request.getParameter("forAddingProduct") == null) {
			request.setAttribute("error", "please log in to continue");
			request.setAttribute("destination", "AddingForm");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/EmployeeLogIn.jsp");
			view.forward(request, response);
			return false;
		}
		else return true;
	}

}













































