<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
	<c:import url="view/header.jsp" />
	<main>
	<article class="display">
		<div class="message">
			Are you sure?
			<form action="${requestScope.positiveAnswer}"
				method="post">
				<button>Yes</button>
			</form>
			<form action="${requestScope.negativeAnswer}">
				<button>No</button>
			</form>
		</div>
	</article>
	</main>
	<c:import url="view/footer.jsp" />
</body>
</html>
