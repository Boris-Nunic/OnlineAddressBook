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
 * Servlet implementation class MyContactsController
 */
public class MyContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer userId = (Integer)request.getSession().getAttribute("userId");
		ArrayList<Contact> contacts = ContactService.getAllContacts(userId);
		String message = (String)request.getSession().getAttribute("message");
		request.getSession().removeAttribute("message");
		request.setAttribute("message", message);
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("myContacts.jsp").forward(request, response);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
