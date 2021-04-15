<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Student" %>
    <%@page import="service.DBServices" %>
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
	DBServices db=new DBServices();
	Connection conn=db.connectDB();
	PreparedStatement ps=conn.prepareStatement("INSERT INTO student(bid, cuid,nameBySSC, gender, currentCity, dateOfBirth, languagesKnown, emailId, phoneNumber, whatsappNumber, homeTown, state, course, institute, dreamCompanies, postgrad, gradCourse, gradPercent,gradCGPA, gradYear, gradInsititute, gradUniversity, gradCityState, hscPercent,hscCGPA, hscYear, sscPercent,sscCGPA, sscYear, gap, yearsOfGap, workExp, companyName, companyLoc, yearsOfExp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	ps.setInt(1,std.getBid());
	ps.setInt(2,std.getCuid());
	ps.setString(3,std.getNameBySSC());
	ps.setString(4,std.getGender());
	ps.setString(5,std.getCurrentCity());
	java.sql.Date dob = new java.sql.Date(std.getDateOfBirth().getDate());
	ps.setDate(6,dob);
	ps.setString(7,std.getLanguagesKnown());
	ps.setString(8,std.getEmaiId());
	ps.setString(9,std.getPhoneNumber());
	ps.setString(10,std.getWhatsappNumber());
	ps.setString(11,std.getHomeTown());
	ps.setString(12,std.getState());
	ps.setString(13,std.getCourse());
	ps.setString(14,std.getInstitute());
	ps.setString(15,std.getDreamCompanies());
	ps.setString(16,std.getPostgrad());
	ps.setString(17,std.getGraduationCourse());
	ps.setDouble(18,std.getGraduationPercent());
	ps.setDouble(19,std.getGradCGPA());
	ps.setString(20,std.getGraduationYear());
	ps.setString(21,std.getGraduationInstitute());
	ps.setString(22,std.getGraduationUniversity());
	ps.setString(23,std.getGraduationCityState());
	ps.setDouble(24,std.getHscPercent());
	ps.setDouble(25,std.getHscCGPA());
	ps.setString(26,std.getHscYear());
	ps.setDouble(27,std.getSscPercent());
	ps.setDouble(28,std.getSscCGPA());
	ps.setString(29,std.getSscYear());
	ps.setString(30,std.getEducationalGap());
	ps.setInt(31,std.getYearsOfGap());
	ps.setString(32,std.getWorkExperience());
	ps.setString(33,std.getCompanyName());
	ps.setString(34,std.getCompanyLocation());
	ps.setString(35,std.getYearsOfExperience());
	int rs=ps.executeUpdate();
	
}

%>
<%
Student std=new Student();
std.setNameBySSC(request.getParameter("name"));
std.setGender(request.getParameter("gender"));
std.setCurrentCity(request.getParameter("currCity"));
String sDate1=request.getParameter("birthday");
Date date=new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
std.setDateOfBirth(date);
std.setLanguagesKnown(request.getParameter("langKnown"));
std.setEmaiId(request.getParameter("emailId"));
std.setPhoneNumber(request.getParameter("phoneNo"));
std.setWhatsappNumber(request.getParameter("whatsappNo"));
std.setHomeTown(request.getParameter("homeCity"));
std.setState(request.getParameter("homeState"));
String courseDetails=request.getParameter("currentCourse");
String[] arr1=courseDetails.split(", ");
std.setCuid(Integer.parseInt(arr1[0]));
std.setCourse(arr1[1]);
String batchDetails=request.getParameter("currentBatch");
String[] arr2=batchDetails.split(", ");
std.setBid(Integer.parseInt(arr2[0]));
std.setInstitute(request.getParameter("currentInstitute"));
std.setDreamCompanies(request.getParameter("dreamCompanies"));
std.setPostgrad(request.getParameter("pgInfo"));
std.setGraduationCourse(request.getParameter("graduation"));
if(request.getParameter("UGcgpaGrade")==null){
	std.setGraduationPercent(Double.parseDouble(request.getParameter("gradPercent")));	
}
else{
	std.setGradCGPA(Double.parseDouble(request.getParameter("UGcgpaGrade")));
}
std.setGraduationYear(request.getParameter("graduationPassoutYear"));
std.setGraduationInstitute(request.getParameter("gradInstitute"));
std.setGraduationUniversity(request.getParameter("gradUniversity"));
std.setGraduationCityState(request.getParameter("gradCityState"));
if(request.getParameter("HSCcgpaGrade")==null){
	std.setHscPercent(Double.parseDouble(request.getParameter("hscPercent")));	
}
else{
	std.setHscCGPA(Double.parseDouble(request.getParameter("HSCcgpaGrade")));
}
std.setHscYear(request.getParameter("hscYear"));
if(request.getParameter("SSCcgpaGrade")==null){
	std.setSscPercent(Double.parseDouble(request.getParameter("sscPercent")));	
}
else{
	std.setSscCGPA(Double.parseDouble(request.getParameter("SSCcgpaGrade")));
}
std.setSscYear(request.getParameter("sscYear"));
std.setEducationalGap(request.getParameter("gap"));
std.setYearsOfGap(Integer.parseInt(request.getParameter("yearsOfGap")));  
std.setWorkExperience(request.getParameter("exp"));
std.setCompanyName(request.getParameter("companyName"));
std.setCompanyLocation(request.getParameter("companyLoc"));
std.setYearsOfExperience(request.getParameter("yearsOfExp"));
//setStudentDatatoDB(std);

%>
</body>
</html>