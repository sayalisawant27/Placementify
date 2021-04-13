<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="models.Student" %>
    <%@page import="services.DatabaseServices" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo</title>
</head>
<body>
<%!
	void setStudentDatatoDB(Student std)throws Exception{
	DatabaseServices db=new DatabaseServices();
	Connection conn=db.connectDB();
	PreparedStatement ps=conn.prepareStatement("INSERT INTO student(bid, cuid, fid, nameBySSC, gender, currentCity, dateOfBirth, languagesKnown, emailId, phoneNumber, whatsappNumber, homeTown, state, course, institute, dreamCompanies, postgrad, gradCourse, gradPercent, gradYear, gradInsititute, gradUniversity, gradCityState, hscPercent, hscYear, sscPercent, sscYear, gap, workExp, companyName, companyLoc, yearsOfExp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	ps.setInt(1,std.getBid());
	ps.setInt(2,std.getCuid());
	ps.setInt(3,1);
	ps.setString(4,std.getNameBySSC());
	ps.setString(5,std.getGender());
	ps.setString(6,std.getCurrentCity());
	java.sql.Date dob = new java.sql.Date(std.getDateOfBirth().getDate());
	ps.setDate(7,dob);
	ps.setString(8,std.getLanguagesKnown());
	ps.setString(9,std.getEmaiId());
	ps.setString(10,std.getPhoneNumber());
	ps.setString(11,std.getWhatsappNumber());
	ps.setString(12,std.getHomeTown());
	ps.setString(13,std.getState());
	ps.setString(14,std.getCourse());
	ps.setString(15,std.getInstitute());
	ps.setString(16,std.getDreamCompanies());
	ps.setString(17,std.getPostgrad());
	ps.setString(18,std.getGraduationCourse());
	ps.setDouble(19,std.getGraduationPercent());
	ps.setString(20,std.getGraduationYear());
	ps.setString(21,std.getGraduationInstitute());
	ps.setString(22,std.getGraduationUniversity());
	ps.setString(23,std.getGraduationCityState());
	ps.setDouble(24,std.getHscPercent());
	ps.setString(25,std.getHscYear());
	ps.setDouble(26,std.getSscPercent());
	ps.setString(27,std.getSscYear());
	ps.setString(28,std.getEducationalGap());
	ps.setString(29,std.getWorkExperience());
	ps.setString(30,std.getCompanyName());
	ps.setString(31,std.getCompanyLocation());
	ps.setString(32,std.getYearsOfExperience());
	int rs=ps.executeUpdate();
	
}

%>
<%
Student std=new Student();
std.setBid(1);
std.setCuid(1);
std.setNameBySSC("John");
std.setGender("male");
std.setCurrentCity("Pune");
String sDate1="27-10-1999";
Date date=new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
std.setDateOfBirth(date);
std.setLanguagesKnown("English");
std.setEmaiId("john.abc@gmail.com");
std.setPhoneNumber("9876543210");
std.setWhatsappNumber("9876543210");
std.setHomeTown("Pune");
std.setState("Maharashtra");
std.setCourse("MCA");
std.setInstitute("DYPIMR");
std.setDreamCompanies("Infosys,Wipro,Cognizant");
std.setPostgrad("");
std.setGraduationCourse("BSC(CS)");
std.setGraduationPercent(85.1);
std.setGraduationYear("2020");
std.setGraduationInstitute("ICCS");
std.setGraduationUniversity("SPPU");
std.setGraduationCityState("Pune Maharashtra");
std.setHscPercent(71.5);
std.setHscYear("2017");
std.setSscPercent(87.4);
std.setSscYear("2015");
std.setEducationalGap("no");
std.setWorkExperience("no");
std.setCompanyName("");
std.setCompanyLocation("");
std.setYearsOfExperience("");
setStudentDatatoDB(std);
out.print("Data inserted");
%>
</body>
</html>