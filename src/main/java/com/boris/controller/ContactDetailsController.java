package com.boris.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boris.model.entities.Contact;
import com.boris.model.entities.User;
import com.boris.model.service.ContactService;

/**
 * Servlet implementation class ContactDetailsController
 */
public class ContactDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer contactId =Integer.parseInt(request.getParameter("contactId"));
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Contact contact = ContactService.getContact(contactId, userId);
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("contactDetails.jsp").forward(request, response);
	}
}
