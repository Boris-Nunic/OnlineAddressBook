<!DOCTYPE html>

<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

	<head>
		<title>Online Address Book</title>
		<link href="css/styles.css" type="text/css" rel="stylesheet"/>
	</head>
	
	<body>
		<div id="page">
			<header>
			
				<figure id="logo">
					<img src="img/addressBookLogo.png" />
					<figcaption hidden="true">Online Address Book Logo</figcaption>
				</figure>
				
				<h1 id="pageTitle">Online Address Book</h1>
		
				<nav>
					<a href="addContact">Add Contact</a>
					<a href="userProfile">My Profile</a>
				</nav>
			
			</header>
		
			<main>
				<div class="message">
					<c:out value="${requestScope.addContactMessage}"></c:out>
				</div>
				
				<div class="search">
				<form action="searchContacts" method="get">
					<label for="contctSearch" hidden="true">Search contacts</label>
					<input type="text" name="searchQuery" id="contactSearch"/>
					<input type="submit" value="Search"/>
				</form>	
				</div>
		
				<table id="contacts">
					<tr class="head">
						
						<th scope="col">&#35No</th>
						<th scope="col">First Name</th>
						<th scope="col">Surname</th>
						<th scope="col">Phone Numbr</th>
						<th scope="col" colspan="2">Some Buttons</th>
					</tr>
					<c:forEach items="${requestScope.contacts}" var="contact" varStatus="loop">
					<tr class="<c:if test="${loop.count % 2 != 0}">odd</c:if>">
						<td>${loop.count}</td>
						<td>${contact.personalInfo.firstName}</td>
						<td>${contact.personalInfo.surname}</td>
						<td>${contact.personalInfo.phoneNumber}</td>
						<td>
							<form action="">
								<button class="contactTableButton" value="" >Details</button>
							</form>
						</td>
						<td>
							<form action="">
								<button class="contactTableButton" value="" >Delete</button>
							</form>
						</td>
					</tr>
					</c:forEach>
					
<!-- 					<tr class="odd"> -->
<!-- 						<td>2</td> -->
<!-- 						<td>Onother</td> -->
<!-- 						<td>Surnameeeee</td> -->
<!-- 						<td>222111</td> -->
<!-- 						<td><input class="contactTableButton"  type="button" value="details" /></td> -->
<!-- 						<td><input class="contactTableButton" type="button" value="delete" /></td> -->
<!-- 					</tr> -->
					
<!-- 					<tr> -->
<!-- 						<td>3</td> -->
<!-- 						<td>Ono-More</td> -->
<!-- 						<td>Surname</td> -->
<!-- 						<td>222333</td> -->
<!-- 						<td><input class="contactTableButton" type="button" value="details" /></td> -->
<!-- 						<td><input class="contactTableButton" type="button" value="delete" /></td> -->
<!-- 					</tr> -->
				</table>
				
			</main>
		
			<aside>
				<div class="adverts">
					<figure class="adverts">
						<image src="img/bildit.png">
						<figcaption hidden="true">Bildit ad</figcaption>
					</figure>
				</div>
				<div class="adverts">
					<figure class="adverts">
						<img src="img/java.png">
					</figure>
				</div>
				
				<div class="adverts">
					<figure class="adverts">
						<img src="img/htmlCss.png">
					</figure>
				</div>
			</aside>
		
			<footer>
			<div id="externalLinks">
				<a href="https://www.youtube.com">YouTube</a>
				<a href="https://www.wikipedia.org">Wikipedia</a>
				<a href="https://www.yts.ag">YIFY Torrentz</a>
				<a href="https://www.imdb.com">IMDb</a>
			</div>	
			</footer>
			
		</div>
		
	</body>


</html>