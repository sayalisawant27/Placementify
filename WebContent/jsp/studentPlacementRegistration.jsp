<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.DBServices"%>
<%@ page import="model.Course"%>
<%@ page import="model.Batch"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Base64"%>
<%-- jsp code estart --%>

<%
	Course course = new Course();
	Batch batch = new Batch();
	DBServices db = new DBServices();
	Connection conn = db.connectDB();
	ResultSet courseRS, batchRS;
	courseRS = db.getAllData("course");
	batchRS = db.getAllData("batch");
	//log(Base64.getDecoder().decode("Y291cnNl").toString());
	//Base64.getDecoder().decode("YmF0Y2g=").toString()
%>
<%!void populateCourse() {

	}%>
<%-- jsp code end --%>
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
<title>DYPIMR | Student Registration</title>
</head>
<body>

	<nav class="red darken-4" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="#" class="brand-logo">DYPIMR</a>
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
			<input type="hidden" name="formId" id="formId">
			<form id="resume-upload-form"></form>
			<form id="photo-upload-form"></form>
			<form class="col s12" method="post" action="../sendToDB.jsp">

				<div class="card">
					<div class="card-content">
						<span class="card-title activator grey-text text-darken-4">Student
							Form</span><br>
						<p>Personal Information</p>
						<br>

						<div class="row">
							<div class="input-field col s12 l12">
								Full Name as per SSC Marksheet <input type="text" name="name"
									id="name" placeholder="Enter your full name" required>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								Email Id <input type="email" name="emailId" id="emailId"
									placeholder="Enter your email id" required>
							</div>
						</div>

						<div class="row">
							<div class="col s12 l6">
								<div class="input-field">
									Phone Number <input type="tel" id="phoneNo" name="phoneNo"
										placeholder="9876543210"
										onchange="phoneNoValidate(this,'phoneNumberError')"
										maxLength="10" required> <span id="phoneNumberError"></span>
								</div>
							</div>
							<div class="col s1 l1"></div>
							<div class="col s12 l6">
								<div style="margin-bottom: 0px !important;" class="input-field">
									WhatsApp Number <input
										onchange="phoneNoValidate(this,'waNumberError')" type="tel"
										id="whatsappNo" name="whatsappNo" placeholder="9876543210"
										maxLength="10" required> <span id="waNumberError"></span>
								</div>
								<p>
									<label> <input style="height: 3px; width: 3px;"
										type="checkbox" class="filled-in" class="right-align"
										onchange="sameAsPhone()" /> <span>Same as Phone Number</span>
									</label>
								</p>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								<!-- class="browser-default" -->
								Gender <select class="browser-default" name="gender" id="gender"
									required>
									<option value="" disabled selected>Select gender</option>
									<option value="male">Male</option>
									<option value="female">Female</option>
									<option value="other">Other</option>
								</select>
							</div>
							<div class="input-field col s12 l6">
								Date of Birth <input type="text" class="datepicker"
									id="birthday" name="birthday" required>
							</div>
						</div>

						<div class="row">
							<div class="col s12 l6">
								Select Current State: <select class="browser-default"
									onchange="onStateValueChanged('currState',this.value)"
									name="currState" id="currState" size="1" required>
									<option value="" selected="selected">Select an item</option>
								</select>
							</div>
							<div class="col s12 l6">
								Select Current City: <select class="browser-default"
									name="currCity" id="currCity" size="1" required>
									<option value="" selected="selected">Select a state
										first</option>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="col s12 l6">
								Select Home State: <select class="browser-default"
									name="homeState"
									onchange="onStateValueChanged('homeState',this.value)"
									id="homeState" size="1" required>
									<option value="" selected="selected">Select an item</option>
								</select>
							</div>
							<div class="col s12 l6">
								Select Home City: <select class="browser-default"
									name="homeCity" id="homeCity" size="1" required>
									<option value="" selected="selected">Select a state
										first</option>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12">
								Languages Known<br>
								<p>
									<label> <input type="checkbox" name="langKnown"
										value="English" id="langEnglish" class="filled-in" /> <span>English</span>
									</label><br> <label> <input type="checkbox"
										name="langKnown" value="Hindi" id="langHindi"
										class="filled-in" /> <span>Hindi</span>
									</label><br> <label> <input type="checkbox"
										name="langKnown" value="Marathi" id="langMarathi"
										class="filled-in" /> <span>Marathi</span>
									</label><br> <input id="Others" name="langKnown"
										placeholder="Others" type="text" id="langOther"
										class="validate">
								</p>
							</div>
						</div>

						<div class="row">
							<%--onchange="courseValueChanged(this.value)" --%>
							<div class="input-field col s12 l6">

								Select Course <select class="browser-default"
									name="currentCourse" id="currentCourse" size="1" required>
									<option value="" selected="selected">Select a course</option>
									<%
										while (courseRS.next()) {
											out.println("<option value=" + courseRS.getInt(1) + ">" + courseRS.getInt(1) + ", "
													+ courseRS.getString(2) + "</option>");
										}
									%>
								</select>
							</div>
							<div class="input-field col s12 l6">
								Select Batch <select class="browser-default" name="currentBatch"
									id="currentBatch" required>
									<option value="" selected="selected">Select a batch</option>
								</select>
							</div>
							<%
								
							%>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								<label for="currentInstitute">Your current
									Institute/College Name</label> <input type="text" disabled="true"
									name="currentInstitute"
									value="Dr. D.Y. Patil Institute of Management and Research, Pimpri"
									placeholder="Dr. D.Y. Patil Institute of Management and Research, Pimpri" />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								<label for="dreamCompanies">Dream companies</label> <input
									type="text" name="dreamCompanies" id="dreamCompanies"
									value="NA" placeholder="E.x. Infosys, TCS, Cognizant ,etc." />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								<label for="pgInfo">Post Graduation (optional)</label> <input
									type="text" name="pgInfo" id="pgInfo" value="NA"
									placeholder="E.x. MSc, MCA ,etc." />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								Graduation<br>
								<p>
									<br> <label> <input name="group1" type="radio"
										name="graduation" value="BBA" class="filled-in"
										onclick="CourseEnableDisableTextBox(this)" /> <span>BBA</span>
									</label><br> <label> <input name="group1" type="radio"
										name="graduation" value="BCA" class="filled-in"
										onclick="CourseEnableDisableTextBox(this)" /> <span>BCA</span>
									</label><br> <label> <input name="group1" type="radio"
										name="graduation" value="BScCS" class="filled-in"
										onclick="CourseEnableDisableTextBox(this)" /> <span>BSc
											Computer Science</span>
									</label><br> <label> <input name="group1" type="radio"
										name="graduation" value="BE" class="filled-in"
										onclick="CourseEnableDisableTextBox(this)" /> <span>BE</span>
									</label><br> <label> <input name="group1" type="radio"
										name="graduation" value="BScOther" class="filled-in"
										onclick="CourseEnableDisableTextBox(this)" /> <span>BSc
											(Other)</span>
									</label><br> <label> <input name="group1" type="radio"
										name="graduation" value="Other" class="filled-in"
										onclick="CourseEnableDisableTextBox(this)" /> <span>Other
											<input group="group1" id="otherGrad" name="graduation"
											placeholder="Others" type="text" disabled="disabled">
									</span>
									</label>
								</p>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								Graduation Passout Year (YYYY) <input type="text"
									name="graduationPassoutYear" value="" placeholder="E.x. 2020" />
							</div>
							<div class="input-field col s12 l6">
								Graduation Marking Scheme <select class="browser-default"
									name="UGgradingSystem" id="UGgradingSystem" size="1"
									onclick="UGEnableDisableTextBox(this)">
									<option value="" selected="selected">Select an option</option>
									<option value="percent">Percentage</option>
									<option value="cgpa10">CGPA (10 Point Scale)</option>
									<option value="cgpa7">CGPA (7 Point Scale)</option>
									<option value="cgpa5">CGPA (5 Point Scale)</option>
									<option value="cgpa4">CGPA (4 Point Scale)</option>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								CGPA Grade
								<!-- onchange="gradeSystemSelected(this.value)" -->
								<input type="text" name="UGcgpaGrade" id="UGcgpaGrade" value=""
									placeholder="E.g. 8.9" disabled="disabled" />
							</div>
							<div class="input-field col s12 l6">
								Percentage (Without %) <input type="text" name="gradPercent"
									id="gradPercent" value="" placeholder="E.g. 82.6"
									disabled="disabled" />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								<label for="gradInstitute">Graduation Institute</label> <input
									type="text" name="gradInstitute" value=""
									placeholder="Enter your College name of graduation." />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								<label for="gradUniversity">Graduation University</label> <input
									type="text" name="gradUniversity" value=""
									placeholder="E.g. Savitribai Phule Pune University" />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								<label for="gradCityState">Graduation City & State </label> <input
									type="text" name="gradCityState" value=""
									placeholder="E.g. City,State" />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								HSC Passout Year (YYYY) <input type="text" name="hscYear"
									value="" placeholder="E.x. 2020" />
							</div>
							<div class="input-field col s12 l6">
								HSC Marking Scheme <select class="browser-default"
									name="HSCgradingSystem" id="HSCgradingSystem" size="1"
									onclick="HSCEnableDisableTextBox(this)">
									<option value="" selected="selected">Select an option</option>
									<option value="percent">Percentage</option>
									<option value="cgpa10">CGPA (10 Point Scale)</option>
									<option value="cgpa7">CGPA (7 Point Scale)</option>
									<option value="cgpa5">CGPA (5 Point Scale)</option>
									<option value="cgpa4">CGPA (4 Point Scale)</option>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								CGPA Grade
								<!-- onchange="gradeSystemSelected(this.value)" -->
								<input type="text" name="HSCcgpaGrade" id="HSCcgpaGrade"
									value="" placeholder="E.g. 8.9" disabled="disabled" />
							</div>
							<div class="input-field col s12 l6">
								Percentage (Without %) <input type="text" name="hscPercent"
									id="hscPercent" value="" placeholder="E.g. 82.6"
									disabled="disabled" />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								SSC Passout Year (YYYY) <input type="text" name="sscYear"
									value="" placeholder="E.x. 2020" />
							</div>
							<div class="input-field col s12 l6">
								SSC Marking Scheme <select class="browser-default"
									name="SSCgradingSystem" id="SSCgradingSystem" size="1"
									onclick="SSCEnableDisableTextBox(this)">
									<option value="" selected="selected">Select an option</option>
									<option value="percent">Percentage</option>
									<option value="cgpa10">CGPA (10 Point Scale)</option>
									<option value="cgpa7">CGPA (7 Point Scale)</option>
									<option value="cgpa5">CGPA (5 Point Scale)</option>
									<option value="cgpa4">CGPA (4 Point Scale)</option>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								CGPA Grade
								<!-- onchange="gradeSystemSelected(this.value)" -->
								<input type="text" name="SSCcgpaGrade" value=""
									placeholder="E.g. 8.9" id="SSCcgpaGrade" disabled="disabled" />
							</div>
							<div class="input-field col s12 l6">
								Percentage (Without %) <input type="text" name="sscPercent"
									id="sscPercent" value="" placeholder="E.g. 82.6"
									disabled="disabled" />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								Any Educational Gap?<br>
								<p>
									<br> <label> <input name="group2" type="radio"
										name="gap" value="yes" class="filled-in" /> <span>Yes</span>
									</label><br> <label> <input name="group2" type="radio"
										name="gap" value="no" class="filled-in" /> <span>No</span>
									</label><br>

								</p>
							</div>

							<div class="input-field col s12 l6">
								Work Experience<br>
								<p>
									<br> <label> <input name="group3" type="radio"
										name="exp" value="yes" class="filled-in" /> <span>Yes</span>
									</label><br> <label> <input name="group4" type="radio"
										name="exp" value="no" class="filled-in" /> <span>No</span>
									</label><br>
								</p>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l6">
								<label for="yearsOfGap">Number of years of gap (If no
									gap, type 0)</label> <input type="text" name="yearsOfGap" value=""
									placeholder="E.g. 1" />
							</div>

							<div class="input-field col s12 l6">
								<label for="yearsOfExp">Years of Experience (If no
									experience, type 0)</label> <input type="text" id="yearsOfExp"
									name="yearsOfExp" value=""
									placeholder="E.g. 1 or 0.5 (5 months)"
									oninput="return onlynum('yearsOfExp')" />
							</div>


						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								<label for="companyName">Company Name (If not applicable
									type NA)</label> <input type="text" name="companyName" value=""
									placeholder="Enter company name" />
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12 l12">
								<label for="companyLoc">Company Location (If not
									applicable type NA)</label> <input type="text" name="companyLoc"
									value="" placeholder="E.g. Pune" />
							</div>
						</div>
						<!-- request.setAttribute("formId", "%><script>return finalName</script> --> 
						<div class="row">
							<div class="input-field  col s12 l12">
								<div class="file-field input-field">
									<div class="btn col s12 l2">
									<input id="resumeNameID" form ="resume-upload-form" type="hidden" />
										<input id="resume_max_id" form="resume-upload-form" type="hidden" name="MAX_FILE_SIZE"
											value="16777216" /> <span> Browse </span> <input type="file" form="resume-upload-form" onchange="upload_check(this,'resume_max_id')"
											id="resumeSelectBtn">
									</div>
									<div class="file-path-wrapper cols12 l10">
										<input class="file-path validate" form="resume-upload-form" type="text" placeholder="Click on the button to upload your resume">
									</div>
									<input type="submit" id="resume-upload-button"
										value="Upload Resume" form="resume-upload-form" class="btn"/><span id="resumeResult"></span>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="input-field  col s12 l12">
								<div class="file-field input-field">
									<div class="btn col s12 l2">
										<input id="photo_max_id" type="hidden" name="MAX_FILE_SIZE"
											value="3145728" /> <span>Browse</span> <input type="file" onchange="upload_check(this,'photo_max_id')"
											id="photoSelectBtn">
									</div>
									<div class="file-path-wrapper col s12 l10">
										<input class="file-path validate" type="text" placeholder="Click on the button to upload your passport size photo">
									</div>
									<input type="submit" id="photo-upload-button"
										value="Upload Photo" form="photo-upload-form" class="btn" /><span id="photoResult"></span>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="input-field col s12 l12" align="right">
								<button class="btn waves-effect waves-light" type="submit"
									name="action">
									Submit <i class="material-icons right">send</i>
								</button>
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
		$('#currentCourse').change(function() {
			var data = "";

			$.ajax({
				type : "GET",
				url : "/Placementify/PopulateBatch",
				data : "currentCourse_selectedvalue=" + $(this).val(),

				async : false,
				success : function(response) {
					data = response;
					document.getElementById("currentBatch").innerHTML = data;
					console.log(data);
				},
				error : function() {
					alert('Error occured');
				}
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$('#resume-upload-button').click(function() {
				var form = $('#resume-upload-form');
				var formId=$( "#resumeNameID" ).val();  
				form.submit();
					$.ajax({
						type : "POST",
						url : "/Placementify/TestServlet",
						data : "filedata="+form.serialize()+"&field2="+formId,
						enctype : 'multipart/form-data',
						success : function(result) {
							$('#resumeResult').html(result);
						}
					});
			});
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#photo-upload-button').click(function() {
				var form = $('#photo-upload-form');
				var formId=$( "#formId" ).val();  
				 form.submit();
					$.ajax({
						type : "POST",
						url : '/Placementify/TestServlet',
						data : jQuery.param({ field1: form.serialize(), field2 : formId}),
						enctype : 'multipart/form-data',
						success : function(result) {
							$('#photoResult').html(result);
						}
					});
			});
		});
	</script>
</body>
</html>