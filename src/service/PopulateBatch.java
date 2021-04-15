package service;

import java.io.IOException;
import java.io.PrintWriter;
import service.DBServices;
import model.*;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopulateBatch
 */
@WebServlet("/PopulateBatch")
public class PopulateBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateBatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String courseFieldValue=request.getParameter("currentCourse_selectedvalue");
		int courseFieldId=Integer.parseInt(courseFieldValue.split(", ")[0]);
		String courseFieldName=courseFieldValue.split(", ")[1];
		String batchOptions="";
		
		DBServices db=new DBServices();
		try {
			ResultSet rs=db.getDataByFK("batch","cid",courseFieldId);
			while(rs.next()) {
				batchOptions+="<option value="+ rs.getInt(1) +">" + rs.getInt(1) + ", " + rs.getString(2) + "</option>";
			}
		
		response.getWriter().append(batchOptions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("recieved value==================="+courseFieldId);
	}

}
