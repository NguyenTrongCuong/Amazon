package main.client.interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RemoveFilterInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
		HttpSession session = null;
		if(request.getParameter("productType") == null) {
			RequestDispatcher view = request.getRequestDispatcher("/backToClientHome");
			view.forward(request, response);
			return false;
		}
		synchronized(session = request.getSession()) {
			if(session.getAttribute("categoryFilter") == null ||
			   session.getAttribute("productFilter") == null ||
			   session.getAttribute("categoryOption") == null) {
				RequestDispatcher view = request.getRequestDispatcher("/backToClientHome");
				view.forward(request, response);
				return false;
			}
		}
		return true;
	}

}
