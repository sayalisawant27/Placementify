package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class StudentObjSave
 */
@WebServlet("/StudentObjSave")
public class StudentObjSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentObjSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student std=new Student();
		std.setNameBySSC(request.getParameter("firstName")+" "+request.getParameter("middleName")+" "+request.getParameter("lastName"));
		std.setEmaiId(request.getParameter("emailId"));
		std.setPhoneNumber(request.getParameter("phoneNumber"));
		std.setWhatsappNumber(request.getParameter("whatsappNumber"));
		std.setGender(request.getParameter("gender"));
		SimpleDateFormat format=new SimpleDateFormat("yyyy-dd-mm");
		Date date = null;
		try {
			date = format.parse(request.getParameter("dateOfBirth"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		std.setDateOfBirth(date);
		std.setCurrentState(request.getParameter("currentStateSelect"));
		std.setCurrentCity(request.getParameter("currentCitySelect"));
		std.setHomeState(request.getParameter("homeStateSelect"));
		std.setCurrentCity(request.getParameter("homeCitySelect"));
		String[] langValues=request.getParameterValues("Languages");
		int i=0;
		String langKnown="";
		while(i!=langValues.length) {
			 langKnown+=langValues[i]+",";
			 i++;
		}
		std.setLanguagesKnown(langKnown.substring(0, langKnown.length() - 1));
		std.setCuid(Integer.parseInt(request.getParameter("selectCourse")));
		//course,batchid,batch 
		std.setCurrentInstitute(request.getParameter("currentInstitute"));
		std.setPostgrad(request.getParameter("postGraduation"));
		std.setDreamCompanies(request.getParameter("dreamCompanies"));
		std.setGradCourse(request.getParameter("gradCourseOption"));
		std.setGradYear(request.getParameter("graduationYear"));
		if(request.getParameter("selectGradMakingScheme").contentEquals("percentage")){
			std.setGradPercent(Double.parseDouble(request.getParameter("gradPercentOrCgpa")));	
		}
		else{
			std.setGradCGPA(Double.parseDouble(request.getParameter("gradPercentOrCgpa")));
		}
		
		std.setGradInstitute(request.getParameter("graduationInstitute"));
		std.setGradUniversity(request.getParameter("graduationUniversity"));
		//std.setGradCityState(request.getParameter("gradCityState"));
		std.setHscYear(request.getParameter("hscYear"));
		if(request.getParameter("hscMarkingScheme").contentEquals("percentage")){
			std.setHscPercent(Double.parseDouble(request.getParameter("hscPercentOrCgpa")));	
		}
		else{
			std.setHscCGPA(Double.parseDouble(request.getParameter("hscPercentOrCgpa")));
		}
		std.setSscYear(request.getParameter("sscYear"));
		if(request.getParameter("sscMarkingScheme").contentEquals("percentage")){
			std.setSscPercent(Double.parseDouble(request.getParameter("sscPercentOrCgpa")));	
		}
		else{
			std.setSscCGPA(Double.parseDouble(request.getParameter("sscPercentOrCgpa")));
		}
		
		std.setGap(request.getParameter("educationGap"));
		if(request.getParameter("educationGap").contentEquals("yes"))
			std.setYearsOfGap(Integer.parseInt(request.getParameter("gapYears")));  
		std.setWorkExp(request.getParameter("exp"));
		if(request.getParameter("workExperience").contentEquals("yes"))
			std.setYearsOfExp(Integer.parseInt(request.getParameter("workExpYears")));
		
		std.setCompanyName(request.getParameter("companyName"));
		std.setCompanyLoc(request.getParameter("companyLocation"));
		//setStudentDatatoDB(std);
		std.setResume(request.getParameter("inputGroupFile01"));
		std.setPhoto(request.getParameter("inputGroupFile02"));
		
		response.getWriter().append(request.getParameter("dateOfBirth"));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
	}
	
	public void setStudentDataToDB(Student std) throws Exception {
		DBServices db=new DBServices();
		Connection conn=db.connectDB();
		PreparedStatement ps=conn.prepareStatement("INSERT INTO student(bid, cuid,nameBySSC, gender, currentCity, currentState, dateOfBirth, languagesKnown, emailId, phoneNumber, whatsappNumber, homeCity, homeState, currentCourse, currentBatch, currentInstitute, dreamCompanies, postgrad, gradCourse, gradPercent, gradCGPA, gradYear, gradInsititute, gradUniversity, gradCityState, hscPercent, hscCGPA, hscYear, sscPercent, sscCGPA, sscYear, gap, yearsOfGap, workExp, companyName, companyLoc, yearsOfExp, resume, photo, formId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,std.getBid());
		ps.setInt(2,std.getCuid());
		ps.setString(3,std.getNameBySSC());
		ps.setString(4,std.getGender());
		ps.setString(5,std.getCurrentCity());
		java.util.Date date= std.getDateOfBirth();
		java.sql.Date dob = new java.sql.Date(date.getTime());
		ps.setDate(6,dob);
		ps.setString(7,std.getLanguagesKnown());
		ps.setString(8,std.getEmaiId());
		ps.setString(9,std.getPhoneNumber());
		ps.setString(10,std.getWhatsappNumber());
		ps.setString(11,std.getHomeCity());
		ps.setString(12,std.getHomeState());
		ps.setString(13,std.getCurrentCourse());
		ps.setString(14,std.getCurrentBatch());
		ps.setString(15,std.getCurrentInstitute());
		ps.setString(16,std.getDreamCompanies());
		ps.setString(17,std.getPostgrad());
		ps.setString(18,std.getGradCourse());
		ps.setDouble(19,std.getGradPercent());
		ps.setDouble(20,std.getGradCGPA());
		ps.setString(21,std.getGradYear());
		ps.setString(22,std.getGradInstitute());
		ps.setString(23,std.getGradUniversity());
		//ps.setString(23,std.getGradCityState());
		ps.setDouble(24,std.getHscPercent());
		ps.setDouble(25,std.getHscCGPA());
		ps.setString(26,std.getHscYear());
		ps.setDouble(27,std.getSscPercent());
		ps.setDouble(28,std.getSscCGPA());
		ps.setString(29,std.getSscYear());
		ps.setString(30,std.getGap());
		ps.setInt(31,std.getYearsOfGap());
		ps.setString(32,std.getWorkExp());
		ps.setString(33,std.getCompanyName());
		ps.setString(34,std.getCompanyLoc());
		ps.setInt(35,std.getYearsOfExp());
		ps.setString(36, std.getResume());
		ps.setString(36, std.getPhoto());
		int rs=ps.executeUpdate();
	}

}
