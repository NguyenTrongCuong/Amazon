package main.client.interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class KeyCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
		if(request.getParameter("key") == null) {
			RequestDispatcher view = request.getRequestDispatcher("/backToClientHome");
			view.forward(request, response);
			return false;
		}
		return true;
	}

}





























































