package services;

import java.sql.*;

public class DatabaseServices {
	private static String url="jdbc:mysql://localhost:3306/placementify?useSSL=false";
	private static String username="root";
	private static String password="password";
	
	Connection con;
	Statement stmt;
	
	public DatabaseServices() {
		
	}
	
	public DatabaseServices(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public Connection connectDB() throws SQLException, Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url, username, password);
		return con;
	}
	
	public ResultSet getAllData(String tableName) throws Exception {
		ResultSet rs=null;
		String qry="Select * from "+tableName;
		Connection con1=connectDB();
		stmt=con1.createStatement();
		try {
			rs=stmt.executeQuery(qry);
			return rs;
		}
		catch(Exception e) {
			
		}
		return rs;
	}
	
	
	
}
