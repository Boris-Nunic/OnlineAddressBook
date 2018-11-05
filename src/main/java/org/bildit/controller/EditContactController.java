package org.bildit.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.entities.Contact;
import org.bildit.model.entities.User;
import org.bildit.model.service.ContactService;

/**
 * Servlet implementation class EditContactController
 */
public class EditContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlPattern = "editContact";
		Integer contactId = Integer.parseInt(request.getParameter("contactId"));
		User user = (User)request.getSession().getAttribute("user");
		Contact contact = ContactService.getContact(contactId, user.getId());
		
		request.getSession().setAttribute("contactId", contactId);
		request.setAttribute("contact", contact);
		request.setAttribute("urlPattern", urlPattern);
		request.getRequestDispatcher("addContact.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String dob = request.getParameter("dob");
		Integer id =(Integer)request.getSession().getAttribute("contactId");
		
		Contact contact = new Contact();
		
		if(!dob.equals("")) {
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
		
		String message = ContactService.editContact(contact);
		
		request.getSession().removeAttribute("contactId");
		request.getSession().setAttribute("message", message);
		response.sendRedirect("myContacts");
	}

}
