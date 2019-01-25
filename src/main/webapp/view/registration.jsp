<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/styles.css" type="text/css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="view/header.jsp">
		<c:param name="nav" value="${requestScope.nav}"></c:param>
	</c:import>
	<main>
	<article>
		<fieldset>
			<legend>Register</legend>
			<div>
				<label for="email" class="title">E-mail</label> <input
					class="input-field" id="email" type="email" name="" required />
			</div>
			<div>
				<label for="password" class="title">Password</label> <input
					class="input-field" id="password" type="password" name="" required />
			</div>
			<div>
				<label for="repeatPassword" class="title">Repeat Password</label> <input
					class="input-field" id="repeatPassword" type="password" name=""
					required />
			</div>
			<div>
				<span class="title">Gender</span> <label for="female">Female</label>
				<input id="female" type="radio" name="" value="" /> <label
					for="male">Male</label> <input id="male" type="radio" name=""
					value="" />
			</div>
			<div>
				<input type="submit" id="submit" value="Register" />
			</div>
		</fieldset>
	</article>
	</main>
	<c:import url="view/footer.jsp"></c:import>
</body>
</html>