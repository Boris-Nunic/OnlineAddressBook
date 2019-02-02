package com.boris.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boris.model.entities.User;
import com.boris.model.service.UserService;

/**
 * Servlet implementation class UserProfileController
 */
@WebServlet(urlPatterns = "/profile", initParams = {
		@WebInitParam(name = "profileNav", value = "contacts,edit_profile,logout"),
		@WebInitParam(name = "deleteProfile", value = "delete_profile") })
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		request.setAttribute("nav", config.getInitParameter("profileNav"));
		request.setAttribute("deleteButton", config.getInitParameter("deleteProfile"));
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		User user = UserService.getUserInfo(userId);
		request.setAttribute("bean", user);
		request.getRequestDispatcher("profilePage").forward(request, response);
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
