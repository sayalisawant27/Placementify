<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FileUpload</title>
</head>
<body>
<a>File Upload:</a>
Select file: <br />
<form action="FileUpload" method="post" enctype="multipart/form-data">
<input type="file" name="xlsheet" size="50" accept=".xls,.xlsx" required/>
<br />
<input type="submit" value="Upload File" />
</form>
</body>
</html>