package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.DBServices;

import com.google.gson.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseListAPI
 */
@WebServlet("/BatchListAPI")
public class BatchListAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchListAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonArray data_json=new JsonArray();

	    ResultSet courseResultset=null;
	    try
	    {
	        Connection con=null;
	        int course_count = 0;
	        
	        DBServices dbObj = new DBServices();
	        con = dbObj.connectDB();
	        
	        courseResultset=dbObj.getAllData("batch");

	        JsonObject json_response=new JsonObject();
	        
	        int selectedCourseId = Integer.parseInt(request.getParameter("Id"));

	        while(courseResultset.next())
	        {   
	        	course_count++;
	            JsonObject json=new JsonObject();
	            if(selectedCourseId==courseResultset.getInt("cid")) {
		            json.addProperty("batchId", courseResultset.getInt("bid"));
		            json.addProperty("batchName", courseResultset.getString("batchName"));
		            //json.addProperty("coursePattern", courseResultset.getString("coursePattern"));
		            //json.addProperty("courseDuration", courseResultset.getString("courseDuration"));
		            //json.addProperty("courseUniversity", courseResultset.getString("courseUniversity"));
		            data_json.add(json);	
	            }
	        }
	        
	        System.out.println(data_json);
	        json_response.add("batchData", data_json);

	        response.setContentType("application/Json");

	        response.getWriter().write(json_response.toString());

	        System.out.println(json_response);
	    }
	    
	    catch(Exception ex)
	    {   
	        System.out.println("Exception occured during retrieval of Batch information :"+ex);
	        ex.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
