package service;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadDocsServlet
 */
@WebServlet("/UploadDocsServlet")
public class UploadDocsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadDocsServlet() {
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

		String email = request.getParameter("emailId");
		String phone = request.getParameter("phone");
		ResultSet studentData = null;

		DBServices dbServices = new DBServices();
		try {
			// ,"emailId="+email+" and phoneNumber="+phone+""
			studentData = dbServices.getDataByCols("student", "emailId, phoneNumber, formId, resume, photo");
			while (studentData.next()) {
				int fileCount = 1;
				String resumeStatus = studentData.getString("resume");
				if (resumeStatus.equals("Pending")) {
					String formId = studentData.getString("formId").toString();
					request.setAttribute("studentStatus", "Student already exists and file upload found pending!");

					if (ServletFileUpload.isMultipartContent(request)) {
						System.out.println(studentData.getString("resume"));
						try {
							List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory())
									.parseRequest(request);
							for (FileItem item : multiparts) {
								if (!item.isFormField()) {
									ServletContext config = request.getServletContext();
									String filename = "C:\\"+item.getName();
									System.out.println(filename);
									File fileData = new File(filename);
									item.write(fileData);
								}
							}
							// File uploaded successfully
							request.setAttribute("statusMessage", "File Uploaded Successfully");
							request.getRequestDispatcher("/result.jsp").forward(request, response);
						} catch (Exception ex) {
							request.setAttribute("statusMessage", "File Upload Failed due to " + ex);
						}
					} else {
						request.setAttribute("statusMessage", "No File found");
					}

				}
				/*if (studentData.getString("resume") != "Pending" && studentData.getString("photo") != "Pending") {
					request.setAttribute("studentStatus", "Student already exists and all files uploaded!");
					request.getRequestDispatcher("/messages/FileUploadStatus.html").forward(request, response);
				}*/
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
