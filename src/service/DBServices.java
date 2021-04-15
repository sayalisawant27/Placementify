package service;

import java.sql.*;

import model.Student;

public class DBServices {

    private static String url = "jdbc:mysql://localhost:3306/formcollection?useSSL=false";
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
        Class.forName("com.mysql.jdbc.Driver");
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
    
    void setStudentDatatoDB(Student std)throws Exception{
    	DBServices db=new DBServices();
    	Connection conn=db.connectDB();
    	PreparedStatement ps=conn.prepareStatement("INSERT INTO student(bid, cuid,nameBySSC, gender, currentCity, dateOfBirth, languagesKnown, emailId, phoneNumber, whatsappNumber, homeTown, state, course, institute, dreamCompanies, postgrad, gradCourse, gradPercent,gradCGPA, gradYear, gradInsititute, gradUniversity, gradCityState, hscPercent,hscCGPA, hscYear, sscPercent,sscCGPA, sscYear, gap, yearsOfGap, workExp, companyName, companyLoc, yearsOfExp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    	ps.setInt(1,std.getBid());
    	ps.setInt(2,std.getCuid());
    	ps.setString(3,std.getNameBySSC());
    	ps.setString(4,std.getGender());
    	ps.setString(5,std.getCurrentCity());
    	java.sql.Date dob = new java.sql.Date(std.getDateOfBirth().getDate());
    	ps.setDate(6,dob);
    	ps.setString(7,std.getLanguagesKnown());
    	ps.setString(8,std.getEmaiId());
    	ps.setString(9,std.getPhoneNumber());
    	ps.setString(10,std.getWhatsappNumber());
    	ps.setString(11,std.getHomeTown());
    	ps.setString(12,std.getState());
    	ps.setString(13,std.getCourse());
    	ps.setString(14,std.getInstitute());
    	ps.setString(15,std.getDreamCompanies());
    	ps.setString(16,std.getPostgrad());
    	ps.setString(17,std.getGraduationCourse());
    	ps.setDouble(18,std.getGraduationPercent());
    	ps.setDouble(19,std.getGradCGPA());
    	ps.setString(20,std.getGraduationYear());
    	ps.setString(21,std.getGraduationInstitute());
    	ps.setString(22,std.getGraduationUniversity());
    	ps.setString(23,std.getGraduationCityState());
    	ps.setDouble(24,std.getHscPercent());
    	ps.setDouble(25,std.getHscCGPA());
    	ps.setString(26,std.getHscYear());
    	ps.setDouble(27,std.getSscPercent());
    	ps.setDouble(28,std.getSscCGPA());
    	ps.setString(29,std.getSscYear());
    	ps.setString(30,std.getEducationalGap());
    	ps.setInt(31,std.getYearsOfGap());
    	ps.setString(32,std.getWorkExperience());
    	ps.setString(33,std.getCompanyName());
    	ps.setString(34,std.getCompanyLocation());
    	ps.setString(35,std.getYearsOfExperience());
    	int rs=ps.executeUpdate();
    }	
}
