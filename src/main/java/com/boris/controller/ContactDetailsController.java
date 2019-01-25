package com.boris.controller;

import java.io.IOException;

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
 * Servlet implementation class ContactDetailsController
 */
@WebServlet(urlPatterns = "/details", initParams = @WebInitParam(name = "contactDetailsNav", value = "edit,delete,contacts,profile"))
public class ContactDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		request.setAttribute("nav", config.getInitParameter("contactDetailsNav"));
		Integer contactId = Integer.parseInt(request.getParameter("contactId"));
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Contact contact = ContactService.getContact(contactId, userId);
		request.setAttribute("bean", contact);
		request.getRequestDispatcher("contactDetailsPage").forward(request, response);
	}
}
