package service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import service.DBServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class DocumentUploadUnauth
 */
@WebServlet("/DocumentUploadUnauth")
public class DocumentUploadUnauth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "D:/";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * 
	 * /**
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public DocumentUploadUnauth() {
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
		try {
			DBServices dbObj = new DBServices();
			Connection con = dbObj.connectDB();
			ResultSet rs = null;

			String email = request.getParameter("emailId");
			String phone = request.getParameter("phone");

			PreparedStatement pstmt = con.prepareStatement("select emailId, phoneNumber, formId, resume, photo from student where emailId='?' and phoneNumber='?'");
			pstmt.setString(1, email);
			pstmt.setString(1, phone);

			rs = dbObj.getAllData("student");
			while(rs.next()) {
				System.out.println(rs.getString("emailId"));
			}
			/*
			if (rs != null) {
				while(rs.next()) {
					System.out.println(rs.getString("resume") + " Called me   " + rs.getString("photo"));
					if (rs.getString("resume") == "Pending" && rs.getString("photo") == "Pending") {
						String formId = rs.getString("formId").toString();
						request.setAttribute("studentStatus", "Student already exists and file upload found pending!");
						resumeAndPhotoUpload(formId);
					}
					if (rs.getString("resume") != "Pending" && rs.getString("photo") != "Pending") {
						request.setAttribute("studentStatus", "Student already exists and all files uploaded!");
						request.getRequestDispatcher("/messages/FileUploadStatus.html").forward(request, response);
					}	
				}
			} else {
				request.setAttribute("studentStatus", "Student does not exist, need to register first!");
				request.getRequestDispatcher("/dataCollectForm.html").forward(request, response);
			}*/
		} catch (Exception e) {
		}
	}

	public void resumeAndPhotoUpload(String formId) {
		System.out.println("Called me");
	}
}
