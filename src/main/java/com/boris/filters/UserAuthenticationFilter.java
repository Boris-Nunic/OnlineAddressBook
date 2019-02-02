package com.boris.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserAutenticationFilter
 */
@WebFilter(urlPatterns = { "/profile", "/contacts", "/edit_profile", "/edit_contact", "/delte_profile",
		"/delete_contact", "/details", "/add"})
public class UserAuthenticationFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserAuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId == null) {
			String message = "The credentials are incorrect, please enter corrctrct credetials";
			request.getSession().setAttribute("message", message);
			response.sendRedirect("login");
		}

		else {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", -1);
			chain.doFilter(request, response);
		}

	}

}
