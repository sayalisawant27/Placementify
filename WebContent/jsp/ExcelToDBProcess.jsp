<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="service.DBServices" %>
     <%@ page import="java.sql.*" %>
     <%@ page import="java.util.Date" %>
     <%@ page import="model.Student" %>
	<%@page import="org.apache.poi.poifs.filesystem.*"%>
	<%@page import="org.apache.poi.hssf.usermodel.HSSFSheet"%>
	<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
	<%@page import="org.apache.poi.*"%>
	<%@page import="java.io.*"%>
	<%@page import="java.io.IOException"%>
	<%@page import="javax.sql.*" %>
	<%@page import="java.io.FileInputStream"%>
	<%@page import="java.io.ObjectOutputStream"%>
	<%@page import="org.apache.poi.ss.usermodel.Cell"%>
	<%@page import="org.apache.poi.ss.usermodel.Row"%>
	<%@page import="org.apache.poi.xssf.usermodel.XSSFSheet"%>
	<%@page import="org.apache.poi.xssf.usermodel.XSSFWorkbook"%>
	<%@page import="java.io.File"%>
	<%@page import="org.apache.commons.io.FilenameUtils"%>
	<%@page import="org.apache.commons.fileupload.FileItem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	void parseExcelData(Connection conn, String filePath)throws Exception{
		FileInputStream input = new FileInputStream(filePath);
    	POIFSFileSystem fs = new POIFSFileSystem(input); //creating a new poi reference to the given excel file
    	HSSFWorkbook wb = new HSSFWorkbook(fs);
    	HSSFSheet sheet = wb.getSheetAt(0);
    	Row row;
    	Cell cell;
    	int rowcount=0;
    	Student std;
    	Statement st=conn.createStatement();
    	for(int i=2; i<=sheet.getLastRowNum(); i++){
    		std=new Student();
    		row=sheet.getRow(i);
  			String name=row.getCell(2).getStringCellValue();
  			name=name.toUpperCase();
  			String gender=row.getCell(3).getStringCellValue();
  			String city=row.getCell(4).getStringCellValue();
  			Date dob=row.getCell(5).getDateCellValue();
  			String languages=row.getCell(6).getStringCellValue();
  			String emailid=row.getCell(7).getStringCellValue();
  			String phone=row.getCell(8).getStringCellValue();
  			String whatsapp=row.getCell(9).getStringCellValue();
    		String hometown=row.getCell(10).getStringCellValue();
    		String state=row.getCell(11).getStringCellValue();
    		String course_batch=row.getCell(12).getStringCellValue();
    		String arr[]=course_batch.split(" ");
    		String course=arr[0];
    		String batch=arr[1];
    		String institute=row.getCell(13).getStringCellValue();
    		String dreamCompanies=row.getCell(14).getStringCellValue();
    		String postGrad=row.getCell(15).getStringCellValue();
    		
    		
    		
    		
    		
    		
    		
    	}
	
	}

%>
<%
	String fileName=(String)request.getAttribute("fileName");
	long fileSize=Long.parseLong(request.getAttribute("fileSize").toString());
	Date fileUploadDate=new Date(request.getAttribute("fileUploadDate")+"");
	String filePath=(String)request.getAttribute("filePath");
	if(request.getAttribute("toDoOp")==null){
		DBServices db=new DBServices();
		Connection conn=db.connectDB();
		PreparedStatement stmt=conn.prepareStatement("select * from file where fname=? and fsize=? and uploadDate=?");
		stmt.setString(1,fileName);
		stmt.setLong(2, fileSize);
		java.sql.Date fileDate = new java.sql.Date(fileUploadDate.getDate());
		stmt.setDate(3, fileDate);
		int rs=stmt.executeUpdate();
		if(rs==0){
			stmt=conn.prepareStatement("INSERT INTO file(fid,fname,fsize,uploadDate) VALUES (?,?,?)");
			stmt.setString(1,fileName);
			stmt.setLong(2,fileSize);
			stmt.setDate(3,fileDate);
			parseExcelData(conn,filePath);
			
			
		}
		
		
		//1. file name validation
		//2.if does not exist, file table entry
		//3. read excel file and insert values in student table
		//4. go to excelParsingSuccessfulPage 
		
	out.println(request.getAttribute("fileName"));
	out.println(request.getAttribute("fileSize"));
	out.println(request.getAttribute("fileUploadDate"));
}
	else if(request.getAttribute("toDoOp")=="updateConfirm"){
		//1.drop student value having old fid	
		//2. drop old file entry from file table
		//3. add new entry in file table
		//4. parse excel data (create function for reading excel data and insert in student table, redirection to excel Parsing)
	}

%>
</body>
</html>