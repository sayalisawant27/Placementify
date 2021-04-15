package service;

import java.io.IOException;
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
		std.setNameBySSC(request.getParameter("name"));
		std.setGender(request.getParameter("gender"));
		std.setCurrentCity(request.getParameter("currCity"));
		String sDate1=request.getParameter("birthday");
		Date date;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
			std.setDateOfBirth(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		//String batchDetails=request.getParameter("currentBatch");
		//String[] arr2=batchDetails.split(", ");
		//std.setBid(Integer.parseInt(arr2[0]));
		std.setBid(Integer.parseInt(request.getParameter("currentBatch")));
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

		
	}

}
