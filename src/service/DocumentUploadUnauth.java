package service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
	 
    private static final String UPLOAD_DIRECTORY = "uploads/students/docs";
    private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**

	/**
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
		DBServices dbObj = new DBServices();
		ResultSet rs = null;

		String email = request.getParameter("emailId");
		String phone = request.getParameter("phone");

		System.out.println(email + " --- " + phone);
		Boolean userExists = false;

		try {
			rs = dbObj.getDataByCols("student", "`emailId`, `phoneNumber`, `formId`, `resume`, `photo`");
			if (rs != null) {
				while (rs.next()) {
					if (rs.getString("emailId").toString() == email
							&& rs.getString("phoneNumber").toString() == phone) {
						userExists = true;
					} else {
						userExists = false;
					}
				}

				if (userExists) {
					if (rs.getString("resume").toString() == "Pending"
							&& rs.getString("photo").toString() == "Pending") {
						String formId = rs.getString("formId").toString();
						request.setAttribute("studentStatus", "Student already exists and file upload found pending!");
						resumeAndPhotoUpload(formId);
					}
					if (rs.getString("resume").toString() != "Pending"
							&& rs.getString("photo").toString() != "Pending") {
						request.setAttribute("studentStatus", "Student already exists and all files uploaded!");
						request.getRequestDispatcher("/messages/FileUploadStatus.html").forward(request, response);
					}
				}
			}else {
				request.setAttribute("studentStatus", "Student does not exist, need to register first!");
				request.getRequestDispatcher("/dataCollectForm.html").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void resumeAndPhotoUpload(HttpServletRequest request, HttpServletResponse response,String formId) {

	        if (!ServletFileUpload.isMultipartContent(request)) {
	            PrintWriter writer = response.getWriter();
	            writer.println("Request does not contain upload data");
	            writer.flush();
	            return;
	        }
	         
	        // configures upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(THRESHOLD_SIZE);
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	         
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	         
	        // constructs the directory path to store upload file
	        String uploadPath = getServletContext().getRealPath("")
	            + File.separator + UPLOAD_DIRECTORY;
	        // creates the directory if it does not exist
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	         
	        try {
	            // parses the request's content to extract file data
	            List formItems = upload.parseRequest(request);
	            Iterator iter = formItems.iterator();
	             
	            // iterates over form's fields
	            while (iter.hasNext()) {
	                FileItem item = (FileItem) iter.next();
	                // processes only fields that are not form fields
	                if (!item.isFormField()) {
	                    String fileName = new File(item.getName()).getName();
	                    String filePath = uploadPath + File.separator + fileName;
	                    File storeFile = new File(filePath);
	                     
	                    // saves the file on disk
	                    item.write(storeFile);
	                }
	            }
	            request.setAttribute("message", "Upload has been done successfully!");
	        } catch (Exception ex) {
	            request.setAttribute("message", "There was an error: " + ex.getMessage());
	        }
	        getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	    }
	}

}
