package org.bildit.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.model.entities.User;
import org.bildit.model.service.UserService;

/**
 * Servlet implementation class EditProfileController
 */
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userId = (Integer)request.getSession().getAttribute("userId");
		User user = UserService.getUserInfo(userId);
		String editProfileMessage = (String)request.getSession().getAttribute("editProfileMessage");
		
		if(editProfileMessage != null) {
			request.getSession().removeAttribute("editProfileMessage");
			request.setAttribute("editProfileMessage", editProfileMessage);
		}
		
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("editProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer userId = (Integer)(session.getAttribute("userId"));
		User user = UserService.getUserInfo(userId);

		String firstName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String phoneNumber = request.getParameter("phoneNumber");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String dob = request.getParameter("dob");

		if(!dob.equals("")) {
			user.getPersonalInfo().setDob(Date.valueOf(dob));
		}
		
		user.getPersonalInfo().setFirstName(firstName);
		user.getPersonalInfo().setSurname(surname);
		user.getPersonalInfo().setPhoneNumber(phoneNumber);
		user.getAddress().setStreetAddress(streetAddress);
		user.getAddress().setCity(city);
		user.getAddress().setCountry(country);

		String editProfileMessage = UserService.editProfile(user);

		if (editProfileMessage == null) {
			response.sendRedirect("userProfile");
		}

		else {
			request.getSession().setAttribute("editProfileMessage", editProfileMessage);
			response.sendRedirect("editProfile");
		}

	}

}
