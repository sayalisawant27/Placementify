

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name;
		if(ServletFileUpload.isMultipartContent(request)){
            try {
                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        name = new File(item.getName()).getName();
                        long size=item.getSize();
                        String date=new java.util.Date().toString();
                        item.write( new File("c:/guru/upload" + File.separator + name));
                        String filePath="c:/guru/upload" + File.separator + name;
                        request.setAttribute("fileName", name);
                        request.setAttribute("fileSize", size);
                        request.setAttribute("fileUploadDate", date);
                        request.setAttribute("filePath", filePath);
                        request.setAttribute("toDoOp", "");
                    }
                }
                System.out.print("File Uploaded Successfully");
               //File uploaded successfully
                request.setAttribute("status", "success");
                
               request.setAttribute("gurumessage", "File Uploaded Successfully");
            } catch (Exception ex) {
            	System.out.print("File Upload Failed due to " + ex);
            	request.setAttribute("status", "failed");
               request.setAttribute("gurumessage", "File Upload Failed due to " + ex);
            }         		
        }else{

            request.setAttribute("gurumessage","No File found");
}
		System.out.println("Dispatching");
		String destination = "ExcelToDBProcess.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		requestDispatcher.forward(request, response);
        System.out.println("Dispatch failed");
	}

}
