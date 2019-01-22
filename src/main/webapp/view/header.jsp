<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<figure class="logo">
		<img src="img/addressBookLogo.png" />
		<figcaption hidden="true">Logo for onlline address book</figcaption>
	</figure>
	<h1 class="main-headline">Online Address Book</h1>
	<c:import url="view/nav.jsp" > 
		<c:param name="homeNav" value="${param.homeNav}"></c:param>
	</c:import>
</header>