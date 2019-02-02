package com.boris.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boris.model.entities.Contact;
import com.boris.model.service.ContactService;

/**
 * Servlet implementation class MyContactsController
 */
@WebServlet(urlPatterns = "/contacts", initParams = { @WebInitParam(name = "contactsNav", value = "add,profile,logout"),
		@WebInitParam(name = "0", value = "Something went wrong please try again"),
		@WebInitParam(name = "1", value = "Contact was eddited successfully") })
public class MyContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		request.setAttribute("nav", config.getInitParameter("contactsNav"));
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		String searchQuery = request.getParameter("searchQuery");
		ArrayList<Contact> contacts = null;
		if(searchQuery != null) {
			 contacts = ContactService.searchContacts(searchQuery, userId);
		} 
		else {
			contacts = ContactService.getAllContacts(userId);
		}
		String messageNumber = "" + request.getSession().getAttribute("contatcEditStatus");
		request.getSession().removeAttribute("contatcEditStatus");
		request.setAttribute("message", getServletConfig().getInitParameter(messageNumber));
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("contactsPage").forward(request, response);
	}
}
