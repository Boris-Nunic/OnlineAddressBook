<!DOCTYPE html>

<%@page isELIgnored="false"%>

<html lang="en">

	<head>
		<title>Online Address Book</title>
		<link href="css/styles.css" type="text/css" rel="stylesheet">
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
					<a href="index.html">Home</a>
					<a href="aboutUs.html">About Us</a>
				</nav>
				
			</header>
			
			
			
			<main>
			
				<form action="login" method="post">
				
					<fieldset>
					
						<legend>Login</legend>
							<div>
								<label for="emailLogin">E-mail:</label>
								<input type="email" name="email" id="emailLogin"/>
							</div>
							<div>
								<label for="passwordLogin">Password:</label>
								<input type="password" name="password" id="passwordLogin"/>
							</div>
							
							<input type="submit" value="Login" />
							
							<div class="message"> ${loginMessage} </div>
							
					</fieldset>
				</form>
				
				<form action="registration" method="post">
					
					<fieldset>
					
						<legend>Register</legend>
						
							<p>*If you are not registered you can do that by filling this form</p>
						
							<div>
								<label for="emailRegister">E-mail:</label>
								<input type="email" name="email" id="emailRegister"/><br />
							</div>
							<div>
								<label for="passwordRegister">Password:</label>
								<input type="password" name="password" id="passwordRegister" /><br />
							</div>
							<div>
								<label for="">Repeat Password:</label>
								<input type="password" name="repeatPassword" id="repeatPassword" />
							</div>
						<input type="submit" value="Register" />
						<div class="message">${registrationMessage}</div>						
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