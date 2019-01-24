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
		<c:param name="" />
	</c:import>
	<main>
	<article class="user-info">
		<figure>
			<img class="profile-picture" src="img/noPicture.jpg" />
			<figcaption hidden="true">Profile picture</figcaption>
		</figure>
		<button>Upload Image</button>
		<div>
			<div class="user-info-title">Name:</div>
			<div class="user-info-value">Konjislav</div>
		</div>
		<div>
			<div class="user-info-title">Surname:</div>
			<div class="user-info-value">Konjina</div>
		</div>
		<div>
			<div class="user-info-title">Phone:</div>
			<div class="user-info-value">0190/868-686</div>
		</div>
		<div>
			<div class="user-info-title">City:</div>
			<div class="user-info-value">Konjoville</div>
		</div>
		<div>
			<div class="user-info-title">Country:</div>
			<div class="user-info-value">Konjara</div>
		</div>
	</article>
	</main>
	<c:import url="view/footer.jsp">
		<c:param name="" />
	</c:import>
</body>
</html>