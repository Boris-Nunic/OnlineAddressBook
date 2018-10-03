<!DOCTYPE html>

<%@page isELIgnored="false" %>

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
					<a href="contacts.html">My Contacts</a>
					<a href="index.html">Logout</a>
					<a href="info.html">Edid Profile</a>
					<a href="index.html">Delete Profile</a>
				</nav>
			
			</header>
		
			<main>
			
				<figure id="profilePictureContainer">
					<img id="profilePicture" src="img/profilePrototype.jpg"/>
					<figcaption hidden="true">Profile Picture</figcaption>
				</figure>
				
				<div id="profileInfo">
				<div>
					First Name: <span class="userInfo">${user.personalInfo.firstName} </span>
				</div>
<!-- 				<div> -->
<!-- 					Middle Name: <span class="userInfo">Randome</span> -->
<!-- 				</div>	 -->
				<div>
					Surename: <span class="userInfo">${user.personalInfo.surname}</span>
				</div>
				<div>
					Date of Birth: <span class="userInfo">${user.personalInfo.dob}</span>
				</div>
				<div>
					E-mail: <span class="userInfo">${sessionScope.user.address.email}</span>
				</div>
				<div>
					Street: <span class="userInfo">${user.address.streetAddress}</span>
				</div>
				<div>
					City: <span class="userInfo">${user.address.city}</span>
				</div>
				<div>
					Country: <span class="userInfo">${user.address.country}</span>
				</div>	
				</div>
				
				<!-- <fieldset id="profileButtons">
					
					<input type="button" value="Edit Profile"/>
					<input type="button" value="Delete Profile" />
				
				</fieldset> -->
				
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