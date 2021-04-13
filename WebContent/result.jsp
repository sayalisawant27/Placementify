<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guru Result</title>
</head>
<body>
<%
if(request.getAttribute("status")=="success"){
	out.println(request.getAttribute("gurumessage"));
	out.println("Redirecting to the main page in 2 seconds");%>
	<script>
  setTimeout(function() {
      document.location = "/Placementify/HomePage.html";
  }, 2000); //
</script>
<%}
else{
	out.println(request.getAttribute("gurumessage"));
	out.println("Redirecting to the main page in 2 seconds");
%>
<script>
  setTimeout(function() {
      document.location = "/Placementify/UploadData.jsp";
  }, 2000); 
</script>
<%}
%>

</body>
</html>