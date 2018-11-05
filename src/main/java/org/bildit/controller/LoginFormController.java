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
