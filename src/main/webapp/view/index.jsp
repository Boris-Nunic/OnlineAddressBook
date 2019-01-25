<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="css/styles.css" type="text/css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	
	<c:import url="view/header.jsp">
		<c:param name="nav" value="${requestScope.nav}"></c:param>
	</c:import>

	<main class="main-screen">
	<article class="main-screen">
		<div class="main-screen-register">
			<p id="main-registration">
				Simple online adress book.<br />Join here for free!
			</p>
			<form>
				<input id="main-registration-button" type="submit" value="Register">
			</form>
		</div>
	</article>
	<aside class="main-aside">
		<div class="advertisement-main">
			<figure>
				<image src="img/java.png">
				<figcaption hidden>Java logo</figcaption>
			</figure>
			<div>
				<p>Java is a general-purpose computer-programming language that
					is concurrent, class-based, object-oriented, and specifically
					designed to have as few implementation dependencies as possible. It
					is intended to let application developers "write once, run
					anywhere" (WORA), meaning that compiled Java code can run on all
					platforms that support Java without the need for recompilation</p>
			</div>
		</div>
		<div class="advertisement-main">
			<figure>
				<image src="img/htmlCss.png">
				<figcaption hidden>HTML5 and CSS3 logos</figcaption>
			</figure>
			<div>
				<p>HTML5 is the latest evolution of the standard that defines
					HTML. The term represents two different concepts. It is a new
					version of the language HTML, with new elements, attributes, and
					behaviors, and a larger set of technologies that allows the
					building of more diverse and powerful Web sites and applications</p>
				<p>CSS3 is the latest evolution of the Cascading Style Sheets
					language and aims at extending CSS2.1. It brings a lot of
					long-awaited novelties, like rounded corners, shadows, gradients,
					transitions or animations, as well as new layouts like
					multi-columns, flexible box or grid layouts</p>
			</div>
		</div>
		<div class="advertisement-main">
			<figure>
				<image src="img/jspAndServlet.png">
				<figcaption hidden>JSP and servlet logo</figcaption>
			</figure>
			<div>
				<p>JavaServer Pages is a technology that helps software
					developers create dynamically generated web pages based on HTML,
					XML, or other document types. Released in 1999 by Sun Microsystems,
					JSP is similar to PHP and ASP, but it uses the Java programming
					languag</p>
				<p>A Java servlet is a Java software component that extends the
					capabilities of a server. Although servlets can respond to any
					types of requests they most commonly implement web containers for
					hosting web applications on web servers and thus qualify as a
					server-side servlet web API.</p>
			</div>
		</div>
	</aside>
	</main>

	<c:import url="view/footer.jsp" />

</body>
</html>