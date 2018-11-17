package com.hbc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class StudentAuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentAuthInterceptor.class);

	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();

		String query = req.getQueryString();

		if (query == null || query.equals("null")) {
		
			query = "";
		
		} else {
		
			query = "?" + query;
		
		}

		if (req.getMethod().equals("GET")) {
			
			LOGGER.info("dest : " + (uri + query));
			req.getSession().setAttribute("dest", uri + query);
	
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		

		if (session.getAttribute("stuLogin") == null) {

			LOGGER.info("current user is not logined");
			
			saveDest(request);
			response.sendRedirect("/apply/login");
			
			return false;

		}

		return true;

	}
}
