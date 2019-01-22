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
 * Servlet implementation class LoginFormController
 */
@WebServlet(
		urlPatterns="/login",
		initParams=@WebInitParam(name="loginNav", value="home,register")
		)
public class LoginFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		request.setAttribute("loginNav", config.getInitParameter("loginNav"));
		request.getRequestDispatcher("loginPage").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Integer userId = UserService.login(email, password);
		
		//if(userId != null) {
			request.getSession().setAttribute("userId", userId);
			response.sendRedirect("userProfile");
	//	}
		
//		else {
//			String message = "Email or password is worong, try again";
//			request.getSession().setAttribute("message", message);
////			HttpSession session = request.getSession();
////			session.setAttribute("user", user);
//			response.sendRedirect("loginRegister");
//		}
	}

}
