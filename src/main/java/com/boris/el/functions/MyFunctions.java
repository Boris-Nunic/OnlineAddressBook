package com.boris.el.functions;

import javax.servlet.jsp.JspPage;

public class MyFunctions {
	
	public static String getJspInitParam(JspPage page, String paramName) {
		return page.getServletConfig().getInitParameter(paramName);
	}

}
