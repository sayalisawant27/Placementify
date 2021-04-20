package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValidate
 */
@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginValidate() {
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
		PreparedStatement stmt1;
		ResultSet rs1;
		DBServices db = new DBServices();
		Connection conn;
		try {
			conn = db.connectDB();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			stmt1 = conn.prepareStatement("select * from user  where username=? and password=? and enabled=1");
			stmt1.setString(1, username);
			stmt1.setString(2, password);
			rs1 = stmt1.executeQuery();
			if (rs1!=null) {
				request.setAttribute("loginStatus", "Successful");
				getServletContext().getRequestDispatcher("/HomePage.html").forward(request, response);
			} else {
				request.setAttribute("loginStatus", "Unsuccessful");
				getServletContext().getRequestDispatcher("/LoginPage.html").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
