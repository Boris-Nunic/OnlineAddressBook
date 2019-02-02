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
	<form action="add" method="post">
		<c:import url="view/personalDataForm.jsp" />
	</form>
	</main>
	<c:import url="view/footer.jsp" />
</body>
</html>