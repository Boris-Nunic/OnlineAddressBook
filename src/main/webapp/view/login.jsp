<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/styles.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="view/header.jsp">
		<c:param name="nav" value="${requestScope.nav}" />
	</c:import>
	<main>
	<article>
		<form action="login" method="post">
			<fieldset>
				<legend>Login</legend>
				<div>
					<label for="email" class="title">E-mail</label> <input
						class="input-field" id="email" type="email" name="email" required />
				</div>
				<div>
					<label for="password" class="title">Password</label> <input
						class="input-field" id="password" type="password" name="password" required />
				</div>
				<div>
					<input type="submit" id="submit" value="Login" />
				</div>
			</fieldset>
		</form>
	</article>
	</main>
	<c:import url="view/footer.jsp" />
</body>
</html>