package service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Student std = new Student();
		std.setNameBySSC(request.getParameter("firstName") + " " + request.getParameter("middleName") + " "
				+ request.getParameter("lastName"));
		std.setEmaiId(request.getParameter("emailId"));
		std.setPhoneNumber(request.getParameter("phoneNumber"));
		std.setWhatsappNumber(request.getParameter("whatsappNumber"));
		std.setGender(request.getParameter("gender"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-mm");
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
		std.setHomeCity(request.getParameter("homeCitySelect"));

		String[] Languages = request.getParameterValues("Languages");
		String langKnown = "";
		for (int ele = 0; ele < Languages.length; ele++) {
			if (Languages[ele].equals("OtherLanguages")) {
				String langValues = request.getParameter("otherLanguagesKnown");
				String[] otherLangValues = langValues.split(",");
				for(String otherLangx : otherLangValues) {
					//System.out.println(otherLangx.trim()+", ");
					langKnown+=otherLangx.trim()+",";
				}
			} else {
				langKnown+=Languages[ele]+",";
			}
		}
	
		System.out.println(langKnown.substring(0, langKnown.length() - 1));

		String selectedCourse[] = request.getParameter("selectCourse").split(", ");
		String selectedBatch[] = request.getParameter("selectBatch").split(", ");
		std.setLanguagesKnown(langKnown.substring(0, langKnown.length() - 1));
		std.setCuid(Integer.parseInt(selectedCourse[0]));
		std.setBid(Integer.parseInt(selectedBatch[0]));
		std.setCurrentCourse(selectedCourse[1]);
		std.setCurrentBatch(selectedBatch[1]);
		// course,batchid,batch
		std.setCurrentInstitute("Dr. D. Y. Patil Institute of Management and Research, Pimpri");
		std.setPostgrad(request.getParameter("postGraduation"));
		std.setDreamCompanies(request.getParameter("dreamCompanies"));
		if (request.getParameter("gradCourseOption") == "OtherCourse") {
			std.setGradCourse(request.getParameter("otherCourseName"));
		} else {
			std.setGradCourse(request.getParameter("gradCourseOption"));
		}
		std.setGradYear(request.getParameter("graduationYear"));
		if (request.getParameter("selectGradMarkingScheme") == "percentage") {
			std.setGradPercent(Double.parseDouble(request.getParameter("gradPercentOrCgpa").toString()));
		} else {
			std.setGradCGPA(Double.parseDouble(request.getParameter("gradPercentOrCgpa").toString()));
		}

		std.setGradInstitute(request.getParameter("graduationInstitute"));
		std.setGradUniversity(request.getParameter("graduationUniversity"));
		// std.setGradCityState(request.getParameter("gradCityState"));
		std.setHscYear(request.getParameter("hscYear"));
		if (request.getParameter("selectHSCMakingScheme").equals("percentage")) {
			std.setHscPercent(Double.parseDouble(request.getParameter("hscPercentOrCgpa").toString()));
		} else {
			std.setHscCGPA(Double.parseDouble(request.getParameter("hscPercentOrCgpa").toString()));
		}
		std.setSscYear(request.getParameter("sscYear"));
		if (request.getParameter("selectSSCMakingScheme").equals("percentage")) {
			std.setSscPercent(Double.parseDouble(request.getParameter("sscPercentOrCgpa").toString()));
		} else {
			std.setSscCGPA(Double.parseDouble(request.getParameter("sscPercentOrCgpa").toString()));
		}

		std.setGap(request.getParameter("educationGap"));
		if (request.getParameter("educationGap").equals("yes"))
			std.setYearsOfGap(Integer.parseInt(request.getParameter("gapYears")));
		std.setWorkExp(request.getParameter("workExperience"));
		if (request.getParameter("workExperience").equals("yes"))
			std.setYearsOfExp(Integer.parseInt(request.getParameter("workExpYears")));

		std.setCompanyName(request.getParameter("companyName"));
		std.setCompanyLoc(request.getParameter("companyLocation"));
		// std.setResume(request.getParameter("inputGroupFile01"));
		// std.setPhoto(request.getParameter("inputGroupFile02"));
		// std.setFormId(request.getParameter("formId"));
		std.setResume("Pending");
		std.setPhoto("Pending");
		MessageDigest digest;
		String hashBytes = "";
		try {
			digest = MessageDigest.getInstance("MD5");
			long timeVar = new Date().getTime();
			String inputBytes = timeVar+"";
			Random randNo = new Random();
			String numberRand = randNo.nextDouble()*randNo.nextInt()+"";
			String formId = inputBytes+numberRand;
			hashBytes = digest.digest(formId.getBytes()).toString();
			System.out.println(hashBytes.replace("[B@", ""));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		std.setFormId(hashBytes.replace("[B@", ""));

		int resultCount = 0;
		try {
			resultCount = setStudentDataToDB(std);
			if(resultCount!=0) {
				response.sendRedirect("/HomePage.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String insertCount = resultCount + "";
		// response.getWriter().append("Insert count : "+
		// request.getParameter("gradPercentOrCgpa"));
		System.out.println();

	}

	public int setStudentDataToDB(Student std) throws Exception {
		DBServices db = new DBServices();
		Connection conn = db.connectDB();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO student(bid, cuid, nameBySSC, gender, currentCity, "
				+ " dateOfBirth, languagesKnown, emailId, phoneNumber, whatsappNumber, homeCity, "
				+ "homeState, currentCourse, currentBatch, currentInstitute, dreamCompanies, postgrad, gradCourse, "
				+ "gradPercent, gradCGPA, gradYear, gradInsititute, gradUniversity, hscPercent, "
				+ "hscCGPA, hscYear, sscPercent, sscCGPA, sscYear, gap, yearsOfGap, workExp, companyName, "
				+ "companyLoc, yearsOfExp, resume, photo, formId, currentState) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, std.getBid());
		ps.setInt(2, std.getCuid());
		ps.setString(3, std.getNameBySSC());
		ps.setString(4, std.getGender());
		ps.setString(5, std.getCurrentCity());
		java.util.Date date = std.getDateOfBirth();
		java.sql.Date dob = new java.sql.Date(date.getTime());
		ps.setDate(6, dob);
		ps.setString(7, std.getLanguagesKnown());
		ps.setString(8, std.getEmaiId());
		ps.setString(9, std.getPhoneNumber());
		ps.setString(10, std.getWhatsappNumber());
		ps.setString(11, std.getHomeCity());
		ps.setString(12, std.getHomeState());
		ps.setString(13, std.getCurrentCourse());
		ps.setString(14, std.getCurrentBatch());
		ps.setString(15, std.getCurrentInstitute());
		ps.setString(16, std.getDreamCompanies());
		ps.setString(17, std.getPostgrad());
		ps.setString(18, std.getGradCourse());
		ps.setDouble(19, std.getGradPercent());
		ps.setDouble(20, std.getGradCGPA());
		ps.setString(21, std.getGradYear());
		ps.setString(22, std.getGradInstitute());
		ps.setString(23, std.getGradUniversity());
		// ps.setString(23,std.getGradCityState());
		ps.setDouble(24, std.getHscPercent());
		ps.setDouble(25, std.getHscCGPA());
		ps.setString(26, std.getHscYear());
		ps.setDouble(27, std.getSscPercent());
		ps.setDouble(28, std.getSscCGPA());
		ps.setString(29, std.getSscYear());
		ps.setString(30, std.getGap());
		ps.setInt(31, std.getYearsOfGap());
		ps.setString(32, std.getWorkExp());
		ps.setString(33, std.getCompanyName());
		ps.setString(34, std.getCompanyLoc());
		ps.setInt(35, std.getYearsOfExp());
		ps.setString(36, std.getResume());
		ps.setString(37, std.getPhoto());
		ps.setString(38, std.getFormId());
		ps.setString(39, std.getCurrentState());
		int insertCount = ps.executeUpdate();
		return insertCount;
	}

}
