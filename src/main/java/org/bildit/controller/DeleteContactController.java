package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.service.ContactService;

/**
 * Servlet implementation class DeleteContactController
 */
public class DeleteContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactId = request.getParameter("contactId");
		String message = ContactService.removeContact(contactId);
		request.setAttribute("message", message);
		request.getRequestDispatcher("myContacts").forward(request, response);
	}

}
