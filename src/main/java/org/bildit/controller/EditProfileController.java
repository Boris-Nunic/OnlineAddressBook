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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("editProfile.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) (session.getAttribute("user"));
		
		String firstName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String phoneNumber = request.getParameter("phoneNumber");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		Date dob = Date.valueOf(request.getParameter("dob"));
		
		user.getPersonalInfo().setFirstName(firstName);
		user.getPersonalInfo().setSurname(surname);
		user.getPersonalInfo().setPhoneNumber(phoneNumber);
		user.getPersonalInfo().setDob(dob);
		user.getAddress().setStreetAddress(streetAddress);
		user.getAddress().setCity(city);
		user.getAddress().setCountry(country);
		
		String editProfileMessage = UserService.editProfile(user);
		
		if(editProfileMessage == null) {
			request.getRequestDispatcher("userProfile.jsp").forward(request, response);
		}
		
		else {
			request.setAttribute("editProfileMessage", editProfileMessage);
			request.getRequestDispatcher("editProfile.jsp").forward(request, response);
		}

	}

}
