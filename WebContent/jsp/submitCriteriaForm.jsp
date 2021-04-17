<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="service.DBServices"%>
<%
	
Batch batch = new Batch();
DBServices db = new DBServices();
Connection conn = db.connectDB();
ResultSet batchRS;
batchRS = db.getAllData("batch");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="../css/materialize.min.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Placementify | Criteria Form</title>
</head>
<body>

	<nav class="red darken-4" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="#" class="brand-logo">Placementify</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="#">Admin</a></li>
			</ul>

			<ul id="nav-mobile" class="sidenav">
				<li><a href="#">Admin</a></li>
			</ul>
			<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
		</div>
	</nav>
	
	<div class="container">
		<div class="row">
		
			<form class="col s12" method="post" action="getCriteriaResults.jsg">

				<div class="card">
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Criteria Form</span><br>
						
						<div class="row">
							<div class="input-field col s12">
								Course & Batch<br>
								<p>
								<br>
									<%
										int i=1;
										while (batchRS.next()) {
											String courseName=batchRS.getString(2).substring(0, 3);
											String batchName=batchRS.getString(2).substring(3);
											out.println("<label> <input type='checkbox' name='course_batch' value="+batchRS.getString(2)+" id='course"+i+"' class='filled-in' /> <span>"+courseName+" "+batchName+"</span><br>");
											i++;
										}
									%>
								</p>
							</div>
						</div>
						
						<div class="row">
			
							<div class="input-field col s12 l6">
								Date of Birth <input type="text" class="datepicker"
									id="birthday" name="birthday" onblur="ageCount()" required>
							</div>
							<div class="input-field col s12 l6">
								Age <input type="text" 
									id="age" name="age" value="" required>
							</div>
						
						</div>
						
						<div class="row">
							<div class="input-field col s12">
								Post Graduation<br>
								<p>
								<br> <label> <input type="radio"
										name="pg" value="MCA" class="filled-in"/> <span>Yes</span>
									</label><br> <label> <input type="radio"
										name="pg" value="MBA" class="filled-in"/> <span>No</span>
									</label><br>
								</p>
							</div>
						</div>
						
					</div>
				</div>
			</form>	
		
		</div>
	</div>
	<footer class="page-footer">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">DYPIMR Placement Cell</h5>
					<p class="grey-text text-lighten-4">Dr. D. Y. Patil Institute
						of Management and Research, Pimpri</p>
				</div>
				<div class="col l4 offset-l2 s12">
					<h5 class="white-text">Links</h5>
					<ul>
						<li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">DYPIMR Placement Cell 2021</div>
		</div>
	</footer>

	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="../js/materialize.js"></script>
	<script type="text/javascript" src="../js/materialize.min.js"></script>
	<script type="text/javascript" src="../js/script.js"></script>
	<script type="text/javascript" src="../js/addressDetails.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/core.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/md5.js"></script>
	<script>
</body>
</html>