<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="class">
<c:out value="${param.navBar }" />
	<ul>
		<li><a class="nav-link" href="">Register</a></li>
		<li><a class="nav-link" href="">Login</a></li>
		<li><a class="nav-link" href="">About us</a></li>
	</ul>
</nav>