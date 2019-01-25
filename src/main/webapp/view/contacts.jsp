<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/styles.css" type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="view/header.jsp">
		<c:param name="nav" value="${requestScope.nav}"></c:param>
	</c:import>
	<main>
	<article>
		<form class="search">
			<input class="search-field" type="text" /> <input
				class="search-button" type="submit" value="Search" />
		</form>
		<table>
			<tr class="head">
				<th class="first" scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">E-Mail</th>
				<th scope="col">Phone Number</th>
				<th class="last" scope="col" colspan="2">Options</th>
			</tr>
			<c:forEach items="${requestScope.contacts}" var="contact"
				varStatus="loop">
				<tr class="<c:if test="${loop.count % 2 == 0 }">even</c:if>">
					<td class="number"><c:out value="${loop.count}" /></td>
					<td><c:out value="${contact.personalInfo.firstName}" /></td>
					<td class="email"><c:out value="${contact.address.email}" /></td>
					<td><c:out value="${contact.personalInfo.phoneNumber}" /></td>
					<td>
						<form action="details" method="get">
							<button name="contactId" value="${contact.id}">Details</button>
						</form>
					</td>
					<td>
						<form>
							<button>Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</article>
	</main>
	<c:import url="view/footer.jsp"></c:import>
</body>
</html>