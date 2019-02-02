package com.boris.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boris.model.entities.User;
import com.boris.model.service.UserService;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet(urlPatterns="/edit_profile", initParams=@WebInitParam(name="editProfileNav", value="profile"))
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer userId = (Integer)request.getSession().getAttribute("userId");
		User user = UserService.getUserInfo(userId);
		request.setAttribute("nav", getServletConfig().getInitParameter("editProfileNav"));
		request.setAttribute("bean", user);
		request.getRequestDispatcher("editUserProfile").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		Integer userId = (Integer)(session.getAttribute("userId"));
		String firstName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String phoneNumber = request.getParameter("phoneNumber");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		
		User user = new User();

		if(!dob.equals("")) {
			user.getPersonalInfo().setDob(Date.valueOf(dob));
		}
		
		user.setId(userId);
		user.getPersonalInfo().setFirstName(firstName);
		user.getPersonalInfo().setSurname(surname);
		user.getPersonalInfo().setPhoneNumber(phoneNumber);
		user.getAddress().setStreetAddress(streetAddress);
		user.getAddress().setCity(city);
		user.getAddress().setCountry(country);
		user.getAddress().setEmail(email);

		if (!UserService.editProfile(user)) {
			response.sendRedirect("error");
		}

		else {
			response.sendRedirect("profile");
		}

	}

}
