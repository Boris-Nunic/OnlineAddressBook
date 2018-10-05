<!DOCTYPE html>

<%@page isELIgnored="false"%>

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
					<a href="userProfile.html">My Profile</a>
					<a href="index.html">Logout</a>
				</nav>
				
			</header>
			
			<main>
			<form action="editProfile" method="post">
				<fieldset id="additionalInfo">
				
					<legend>Info</legend>
					
					<div>
					<label>First Name:
						<input type="text" name="firstName" value="${sessionScope.user.personalInfo.firstName}"/><br />
					</label>
					</div>
					<div>
					<label>Surname:
						<input type="text" name="surname"  value="${sessionScope.user.personalInfo.surname}"/>
					</label>
					</div>
<!-- 					<div> -->
<!-- 					<label>E-mail: -->
<!-- 						<input type="email" name="email"  value="${sessionScope.user.address.email}"/> -->
<!-- 					</label> -->
<!-- 					</div> -->
					<div>
					<label>Phone Number:
						<input type="tel" name="phoneNumber"  value="${sessionScope.user.personalInfo.phoneNumber}" />
					</label>
					</div>
					<div>
					<label>Street Address:
						<input type="text" name="streetAddress" value="${sessionScope.user.address.streetAddress}"/>
					</label>
					</div>
					<div>
					<label>City:
						<input type="text" name="city" value="${sessionScope.user.address.city}"/>
					</label>
					</div>
					<div>
					<label>Country:
						<input type="text" name="country" value="${sessionScope.user.address.country}"/>
					</label>
					</div>
					<div>
					<label>Date of Birth:
						<input type="date" name="dob"  value="${sessionScope.user.personalInfo.dob}"/>
					</label>
					</div>
					<div>
						<input type="submit" value="Finish"/>
					</div>
					<div class="message"> ${requestScope.editProfileMessage} </div>
				</fieldset>
				</form>>
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