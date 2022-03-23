package com.SkillMatrixMainFile.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class dbutils {
	private static Connection getRemoteConnection() {
	      try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      String dbName = "skill_matrix_logReg_db";
	      String userName = "root";
	      String password = "bhargava@123";
	      String hostname = "localhost";
	      String port = "3306";
	      String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
	      System.out.println("Getting remote connection with connection string from environment variables.");
	      Connection con = DriverManager.getConnection(jdbcUrl);
	      System.out.println("Remote connection successful.");
	      return con;
	    }
	    catch (ClassNotFoundException e) { 
	    	System.out.println(e.toString());}
	    catch (SQLException e) { 
	    	System.out.println(e.toString());}
	      catch (Exception e) {
	    	  System.out.println(e.toString());}
	    return null;
	  }
	
	public static void main(String[] args) throws SQLException {
		Connection con = dbutils.getRemoteConnection();
		System.out.println(con);
	}
	
	public  static int DbEmployeeRegistration(String email, String name,String password, String role) throws SQLException {
		
		Connection con = dbutils.getRemoteConnection();
		PreparedStatement st = con.prepareStatement("insert into  employee(email, name, password,role)values(?,?,?,?)");
		System.out.println("hi");
		st.setString(1, email);
		st.setString(2, name);
		st.setString(3, password);
		st.setString(4, role);
		int rowAffected= st.executeUpdate();
		return rowAffected;
		

		
		
		
	}
	
	
	public  static ResultSet ValidateLogin(String email) throws SQLException {
		Connection con = dbutils.getRemoteConnection();
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * FROM employee where email='" +email+"'");
        
      
        return rs;
	}
	
	public static ResultSet GetEmployeeProjects(int employeeId, String role) throws SQLException {
		Connection con = dbutils.getRemoteConnection();
		Statement st = con.createStatement();
		ResultSet rs;
		System.out.println(role);
		if(role.equals("admin")) {
			System.out.println("came to admin condition");
			 rs = st.executeQuery("select employee.id, employee.email, employeeProjectDetails.projectName, employeeProjectDetails.employee_id from employee INNER JOIN employeeProjectDetails on employee.id = employeeProjectDetails.employee_id where employee_id = employee.id;");
		}
		else
		{
				System.out.println("came to else condition");
				 rs = st.executeQuery("select employee.id, employee.email, employeeProjectDetails.projectName, employeeProjectDetails.employee_id from employee INNER JOIN employeeProjectDetails on employee.id = employeeProjectDetails.employee_id where employee_id ='" +employeeId+"'");
		}
		
		return rs;
	}

	public ResultSet ValidateCredentials(String email) throws SQLException {
		Connection con = dbutils.getRemoteConnection();
		Statement st = con.createStatement();
		ResultSet rs;
		rs = st.executeQuery("select * from employee where email = '" +email+"'");	
		
		return rs;
	}
	
}






	
