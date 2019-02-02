package com.boris.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boris.model.service.ContactService;

/**
 * Servlet implementation class DeleteContactController
 */
@WebServlet(urlPatterns = "/delete_contact", initParams = {
		@WebInitParam(name = "0", value = "Something went wrong. Please try again"),
		@WebInitParam(name = "negativeAnswer", value = "contacts"),
		@WebInitParam(name = "positiveAnswer", value = "delete_contact") })
public class DeleteContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("negativeAnswer", getServletConfig().getInitParameter("negativeAnswer"));
		request.setAttribute("positiveAnswer", getServletConfig().getInitParameter("positiveAnswer"));
		request.getRequestDispatcher("validateDeletePage").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer contactId = (Integer) request.getSession().getAttribute("contactId");

		int status = ContactService.removeContact(contactId);
		request.getSession().setAttribute("message", getServletConfig().getInitParameter("" + status));

		response.sendRedirect("contacts");

	}

}
