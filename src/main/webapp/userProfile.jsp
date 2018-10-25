<!DOCTYPE html>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

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
					<a href="myContacts">My Contacts</a>
					<a href="editProfile">Edit Profile</a>
					<a href="logout">Logout</a>
 					<a href="deleteProfile">Delete Profile</a> 
				</nav>
			
			</header>
		
			<main>
			
			<div id="pictureAndInfo">
				<figure id="profilePictureContainer">
					<img id="profilePicture" src="img/profilePrototype.jpg"/>
					<figcaption hidden="true">Profile Picture</figcaption>
				</figure>
				
				<input type="button" value="Add Profile Image">
				
				<table id="profileInfo">
					<tr>
						<td>
							<span class="fields">First Name:</span>
						</td>
						<td>
							<span class="userInfo"><c:out value="${sessionScope.user.personalInfo.firstName}"></c:out></span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Surname:</span>
						</td>
						<td>
							<span class="userInfo"><c:out value="${sessionScope.user.personalInfo.surname}"></c:out></span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Date of Birth:</span>
						</td>
						<td>
							<span class="userInfo"><c:out value="${sessionScope.user.personalInfo.dob}"></c:out></span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Phone Number</span>
						</td>
						<td>
							<span class="userInfo"><c:out value="${sessionScope.user.personalInfo.phoneNumber}"></c:out></span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">E-mail:</span>
						</td>
						<td>
							<span class="userInfo"><c:out value="${sessionScope.user.address.email}"></c:out></span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Street:</span>
						</td>
						<td>
							<span class="userInfo"><c:out value="${sessionScope.user.address.streetAddress}"></c:out></span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">City:</span>
						</td>
						<td>
							<span class="userInfo"><c:out value="${sessionScope.user.address.city}"></c:out></span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Country:</span>
						</td>
						<td>
							<span class="userInfo"><c:out value="${sessionScope.user.address.country}"></c:out></span>
						</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td colspan="2"> -->
<!-- 							<form action="deleteProfile" method="post"> -->
<!-- 								<input type="submit" value="Delete Profile"/> -->
<!-- 							</form> -->
<!-- 						</td> -->
<!-- 					</tr> -->
				</table>
			</div>	
							
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
				<a href="https://www.yts.ag">YIFY Torrents</a>
				<a href="https://www.imdb.com">IMDb</a>
			</div>	
			</footer>
		
		</div>
		
	</body>


</html>