package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.entities.User;
import org.bildit.model.service.UserService;

/**
 * Servlet implementation class DeleteProfileController
 */
public class DeleteProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)(request.getSession().getAttribute("user"));
		String deleteProfileMessage = UserService.deleteProfile(user.getId());
		
		if(deleteProfileMessage == null) {
			response.sendRedirect("index.jsp");
		}
		else {
			request.setAttribute("deleteProfileMessage", deleteProfileMessage);
			request.getRequestDispatcher("userProfile.jsp").forward(request, response);
		}
	}

}
