<!DOCTYPE html>

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
					<a href="info.html">My Profile</a>
					<a href="index.html">Logout</a>
					<!-- <a href="index.html">Delete Profile</a> -->
				</nav>
			
			</header>
		
			<main>
			
			<div id="pictureAndInfo">
				<figure id="profilePictureContainer">
					<img id="profilePicture" src="img/profilePrototype.jpg"/>
					<figcaption hidden="true">Profile Picture</figcaption>
					<input type="button" value="Add Image">
				</figure>
				
				
				
				<table id="profileInfo">
					<tr>
						<td>
							<span class="fields">First Name:</span>
						</td>
						<td>
							<span class="userInfo">Some</span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Surname:</span>
						</td>
						<td>
							<span class="userInfo">Bloke</span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Date of Birth:</span>
						</td>
						<td>
							<span class="userInfo">1/1/1111</span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">E-mail:</span>
						</td>
						<td>
							<span class="userInfo">something@somthing.com</span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Street:</span>
						</td>
						<td>
							<span class="userInfo">Street and Number</span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">City:</span>
						</td>
						<td>
							<span class="userInfo">Awsome City</span>
						</td>
					</tr>
					<tr>
						<td>
							<span class="fields">Country:</span>
						</td>
						<td>
							<span class="userInfo">Terrific Country</span>
						</td>
					</tr>
					<tr>
						<td>
							<form action="" method="">
								<button>Edit</button>
							</form>							
						</td>
						<td>
							<form action="" method="">
								<button>Delete</button>
							</form>
						</td>
					</tr>
				</table>
			</div>	
			<!--	<div id="profileInfo">
				<div>
					First Name: <span class="userInfo">Some</span>
				</div>
				<div>
					Middle Name: <span class="userInfo">Randome</span>
				</div>	
				<div>
					Surename: <span class="userInfo">Bloke</span>
				</div>
				<div>
					Date of Birth: <span class="userInfo">1/1/1111</span>
				</div>
				<div>
					E-mail: <span class="userInfo">something@somthing.some</span>
				</div>
				<div>
					Street: <span class="userInfo">Street and Number</span>
				</div>
				<div>
					City: <span class="userInfo">Awsome City</span>
				</div>
				<div>
					Country: <span class="userInfo">Terrific Country</span>
				</div>	
				</div> -->
				
				
				
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