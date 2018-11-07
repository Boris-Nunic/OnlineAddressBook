package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.service.UserService;

/**
 * Servlet implementation class RegistrationFormController
 */
public class RegistrationFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		
		String registrationMessage = UserService.registration(email, password, repeatPassword);
		request.setAttribute("message", registrationMessage);
		
		request.getRequestDispatcher("loginRegister.jsp").forward(request, response);
	}

}
