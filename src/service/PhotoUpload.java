package service;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
	
    // Y?klenecek dizin
    private static final String UPLOAD_DIRECTORY = "assets/images/upload";

    // Upload ayarlar?
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    private static final String UPLOAD_SUCCESS = "Dosya Y?klendi";
    private static final String NO_FILE = "L?tfen Resim Se?in";

	
	private static final long serialVersionUID = 1L;
 
    public PhotoUpload() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/plain");
	        resp.setCharacterEncoding("UTF-8");
	        PrintWriter out = resp.getWriter();
	        if(!ServletFileUpload.isMultipartContent(req)) {
	            out.flush();
	            return;
	        }

	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        File repository = new File(System.getProperty("java.io.tmpdir"));
	        System.out.println(repository.getAbsolutePath());
	        factory.setRepository(repository);
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	        String uploadPath = getServletContext().getRealPath("")
	                + File.separator + UPLOAD_DIRECTORY;
	        System.out.println(uploadPath);

	        try {
	            List<FileItem> images = upload.parseRequest(req);
	            if (images != null && images.size() > 0) {
	                for (FileItem image : images) {
	                    if (!image.isFormField()) {
	                        String fileName = new File(image.getName()).getName() + req.getParameter(['field2']);
	                        String filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	                        image.write(storeFile);
	                        out.print(UPLOAD_SUCCESS);
	                    }
	                    else out.print("File Upload Fail");
	                }
	            } else out.print(NO_FILE);
	        } catch (Exception e) {
	            out.print("Exeption");
	            e.printStackTrace();
	        }
	    }
 
}