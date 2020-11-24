package main.client.interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AccountCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
		HttpSession session = null;
		synchronized(session = request.getSession()) {
			if(session.getAttribute("account") == null) {
				RequestDispatcher view = request.getRequestDispatcher("/backToClientHome");
				view.forward(request, response);
				return false;
			}
		}

		return true;
	}

}

















































