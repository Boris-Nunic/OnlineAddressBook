package com.boris.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boris.model.entities.Contact;
import com.boris.model.service.ContactService;

/**
 * Servlet implementation class EditContactController
 */
@WebServlet(urlPatterns = "/edit_contact", initParams = @WebInitParam(name = "editContactNav", value = "contacts,profile"))
public class EditContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer contactId = (Integer) request.getSession().getAttribute("contactId");
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Contact contact = ContactService.getContact(contactId, userId);
		request.setAttribute("nav", getServletConfig().getInitParameter("editContactNav"));
		request.setAttribute("bean", contact);
		request.getRequestDispatcher("editContactPage").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String dob = request.getParameter("dob");
		Integer id = (Integer) request.getSession().getAttribute("contactId");

		Contact contact = new Contact();

		if (!dob.equals("")) {
			contact.getPersonalInfo().setDob(Date.valueOf(dob));
		}

		contact.setId(id);
		contact.getPersonalInfo().setFirstName(firstName);
		contact.getPersonalInfo().setSurname(surname);
		contact.getPersonalInfo().setPhoneNumber(phoneNumber);
		contact.getAddress().setEmail(email);
		contact.getAddress().setStreetAddress(streetAddress);
		contact.getAddress().setCity(city);
		contact.getAddress().setCountry(country);

		int status = ContactService.editContact(contact);
		request.getSession().setAttribute("contatcEditStatus", status);
		if (status != 0) {
			request.getSession().removeAttribute("contactId");
		}
		response.sendRedirect("contacts");
	}

}
