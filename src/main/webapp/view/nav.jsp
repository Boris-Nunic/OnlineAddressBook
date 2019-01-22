<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="class">
	<ul>
		<c:forEach items="${param.homeNav}" var="link">
		<li><a class="nav-link" href=""><c:out value="${link}" /></a></li>
		</c:forEach>
	</ul>
</nav>