package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.model.entities.HelperClass;
import org.bildit.model.service.UserService;

/**
 * Servlet implementation class LoginFormController
 */
public class LoginFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HelperClass hc = UserService.login(email, password);
		
		if(hc.getMessage() != null) {
			request.setAttribute("loginMessage", hc.getMessage());
			request.getRequestDispatcher("loginRegister.jsp").forward(request, response);
		}
		
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", hc.getUser());
			request.getRequestDispatcher("userProfile.jsp").forward(request, response);
		}
	}

}
