package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.model.entities.User;
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
		User user = UserService.login(email, password);
		
		if(user.getMessage() != null) {
			request.setAttribute("loginMessage", user.getMessage());
			request.getRequestDispatcher("loginRegister").forward(request, response);
		}
		
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("userProfile").forward(request, response);
		}
	}

}
