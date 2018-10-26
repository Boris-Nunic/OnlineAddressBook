package org.bildit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.entities.Contact;
import org.bildit.model.entities.User;
import org.bildit.model.service.ContactService;

/**
 * Servlet implementation class SearchContactsController
 */
public class SearchContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchQuery = request.getParameter("searchQuery");
		User user = (User)request.getSession().getAttribute("user");
		ArrayList<Contact> contacts = ContactService.searchContacts(searchQuery, user.getId());
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("myContacts.jsp").forward(request, response);
	}

}
