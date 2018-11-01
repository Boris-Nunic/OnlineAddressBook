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
					<a href="userProfile">My Profile</a>
					<a href="index.html">Logout</a>
				</nav>
				
			</header>
			
			<main>
			<form action="${requestScope.urlPattern}" method="post">
				<fieldset id="additionalInfo">
				
					<legend>Contact Info</legend>
					
					<div>
					<label>First Name:
						<input type="text" name="firstName" /><br />
					</label>
					</div>
					<div>
					<label>Surname:
						<input type="text" name="surname" />
					</label>
					</div>
					<div>
					<label>E-mail:
						<input type="email" name="email" />
					</label>
					</div>
					<div>
					<label>Phone Number:
						<input type="tel" name="phoneNumber" />
					</label>
					</div>
					<div>
					<label>Street Address:
						<input type="text" name="streetAddress" />
					</label>
					</div>
					<div>
					<label>City:
						<input type="text" name="city" />
					</label>
					</div>
					<div>
					<label>Country:
						<input type="text" name="country" />
					</label>
					</div>
					<div>
					<label>Date of Birth:
						<input type="date" name="dob" />
					</label>
					</div>
					<div>
						<input type="submit" value="Finish">
					</div>
				</fieldset>
				</form>
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