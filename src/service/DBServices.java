package service;

import java.sql.*;

import model.Student;

public class DBServices {

    private static String url = "jdbc:mysql://localhost:3306/placementify?useSSL=false";
    private static String username = "root";
    private static String password = "password";

    Connection connection;
    Statement statement;
    ResultSet resultSet = null;

    public DBServices() { }

    public DBServices(String url, String username, String password) {
        super();
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection connectDB() throws SQLException, Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public ResultSet getAllData(String tableName) throws Exception {
        String queryString = "Select * from " + tableName;
        Connection connection1 = connectDB();
        statement = connection1.createStatement();
        try {
            resultSet = statement.executeQuery(queryString);
            return resultSet;
        } catch(Exception e) { }
        return resultSet;
    }
    
    public ResultSet getDataByFK(String tableName, String fk, int id) throws Exception {
        String queryString = "Select * from " + tableName+" where "+fk+"="+id;
        Connection connection1 = connectDB();
        statement = connection1.createStatement();
        try {
            resultSet = statement.executeQuery(queryString);
            return resultSet;
        } catch(Exception e) { }
        return resultSet;
    }
    
    public ResultSet getDataByCols(String tableName, String colNames) throws Exception {
    	String queryString = "Select "+colNames+" from " + tableName;
        Connection connection1 = connectDB();
        statement = connection1.createStatement();
        try {
            resultSet = statement.executeQuery(queryString);
            return resultSet;
        } catch(Exception e) { }
        return resultSet;
    }
    
}
