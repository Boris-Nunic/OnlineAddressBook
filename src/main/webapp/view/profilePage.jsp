<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/styles.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<c:import url="view/header.jsp">
		<c:param name="nav" value="${requestScope.nav}"/>
	</c:import>
	<main>
		<c:import url="view/information.jsp">
			<c:param name="info" value="${requestScope.user}"></c:param>
		</c:import>
	</main>
	<c:import url="view/footer.jsp">
		<c:param name="" />
	</c:import>
</body>
</html>