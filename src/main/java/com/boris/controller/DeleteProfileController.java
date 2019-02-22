package com.boris.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boris.model.service.UserService;

/**
 * Servlet implementation class DeleteProfileController
 */
@WebServlet(urlPatterns = "/delete_profile", initParams = {
		@WebInitParam(name = "0", value = "Something went wrong. Please try again"),
		@WebInitParam(name = "negativeAnswer", value = "profile"),
		@WebInitParam(name = "positiveAnswer", value = "delete_profile") })
public class DeleteProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("negativeAnswer", getServletConfig().getInitParameter("negativeAnswer"));
		request.setAttribute("positiveAnswer", getServletConfig().getInitParameter("positiveAnswer"));
		request.getRequestDispatcher("validateDeletePage").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		int deleteProfileStatus = UserService.deleteProfile(userId);

		if (deleteProfileStatus != 0) {
			response.sendRedirect("home");
		} else {
			request.setAttribute("deleteProfileMessage", getServletConfig().getInitParameter("" + deleteProfileStatus));
			request.getRequestDispatcher("profile").forward(request, response);
		}
	}

}
