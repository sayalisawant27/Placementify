package service;
import java.io.File;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/PhotoUpload")
@MultipartConfig(maxFileSize = 3145740) // upload file's size up to 16MB
public class PhotoUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PhotoUpload() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        if(ServletFileUpload.isMultipartContent(request)){
		            try {
		                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
		                        String name = new File(item.getName()).getName();
		                        item.write( new File("c:/guru/upload" + File.separator + name));
		                    }
		                }
		               //File uploaded successfully
		               request.setAttribute("gurumessage", "File Uploaded Successfully");
		            } catch (Exception ex) {
		               request.setAttribute("gurumessage", "File Upload Failed due to " + ex);
		            }         		
		        }else{
		
		            request.setAttribute("gurumessage","No File found");
 }
		        request.getRequestDispatcher("/result.jsp").forward(request, response);
		
		
		
		    }
 
 
}