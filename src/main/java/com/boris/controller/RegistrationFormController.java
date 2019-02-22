package com.boris.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boris.model.service.UserService;

/**
 * Servlet implementation class RegistrationFormController
 */
@WebServlet(urlPatterns = "/register", initParams = { @WebInitParam(name = "registrationNav", value = "home,login"),
		@WebInitParam(name = "1", value = "Something went wrong. Please try again"),
		@WebInitParam(name = "2", value = "Provided email adderss is already registered"),
		@WebInitParam(name = "3", value = "Password and reapeted password do not match") })

public class RegistrationFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		request.setAttribute("nav", config.getInitParameter("registrationNav"));
		request.setAttribute("regitstrationMessage",
				getServletConfig().getInitParameter("" + request.getSession().getAttribute("regitstrationStatus")));
		request.getSession().removeAttribute("regitstrationStatus");
		request.getRequestDispatcher("registrationPage").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");

		int registrationStatus = UserService.registration(email, password, repeatPassword);

		if (registrationStatus == 0) {
			request.getRequestDispatcher("login").forward(request, response);
		} else {
			request.getSession().setAttribute("regitstrationStatus", registrationStatus);
			response.sendRedirect("register");
		}

	}

}
