<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="services.DatabaseServices" %>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Placementify Account Login</title>
</head>
<body>
<%
     	int uid;
     	PreparedStatement stmt1,stmt2;
     	ResultSet rs1,rs2;
     	DatabaseServices db=new DatabaseServices();
     	Connection conn=db.connectDB();
     	String username=request.getParameter("username");
     	String password=request.getParameter("password");
     	stmt1=conn.prepareStatement("select * from user where username=? and password=?");
     	stmt1.setString(1, username);
     	stmt1.setString(2,password);
     	rs1=stmt1.executeQuery();
     	if(rs1.next()){
     		response.sendRedirect("http://localhost:8082/Placementify/HomePage.html");
     	}
     		else{
     			response.sendRedirect("http://localhost:8082/Placementify/LoginPage.html");
     		}
     %>
</body>
</html>