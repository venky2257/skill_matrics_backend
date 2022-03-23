package com.SkillMatrixMainFile.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SkillMatrixMainFile.dbUtils.dbutils;
import com.SkillMatrixMainFile.model.Employee;
import com.SkillMatrixMainFile.model.EmployeeBasicDetails;
import com.SkillMatrixMainFile.model.EmployeeDetails;
import com.SkillMatrixMainFile.model.EmployeeProject;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class LoginController {
	@Autowired
	private dbutils dblog;	
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public List<EmployeeBasicDetails> EmployeeLogin(@RequestBody Map<String, Object> employeeCredentials) throws SQLException {
		System.out.println(employeeCredentials);
		List<EmployeeBasicDetails> employeeDetails = new ArrayList();
		String email = employeeCredentials.get("email").toString();
		String password = employeeCredentials.get("password").toString();
		ResultSet rs = dblog.ValidateCredentials(email);
		while(rs.next()) {
			
			
			if(email.equals(rs.getObject("email").toString()) && rs.getString("password").equals(password)) {
				int id =Integer.parseInt(rs.getObject("email").toString());
				System.out.println(id);
				employeeDetails.add(new EmployeeBasicDetails(id,rs.getObject("email").toString(),rs.getObject("name").toString(),rs.getObject("role").toString()));
			}
			
			
		}
		return employeeDetails;
	}
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public List<Employee> Registraion(@RequestBody Map<String, Object> employee) throws SQLException {
		System.out.println(employee);
		String email = employee.get("email").toString();
		String name = employee.get("name").toString();
		String password = employee.get("password").toString();
		String role = employee.get("value").toString();
		if(role == "") {
			role = "admin";
		}
		List<Employee> employeeDetails = new ArrayList();
		int rowsAffected = dbutils.DbEmployeeRegistration(email, name, password, role);
		if(rowsAffected > 0) {
				employeeDetails.add(new Employee(0,email,name, password, role));
		}
		
		return employeeDetails;
		
		
	}
	

	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public List<EmployeeDetails> home(@RequestBody Map<String, Object> employee) throws SQLException {
		System.out.println(employee);
		String email = employee.get("email").toString();
		List<EmployeeDetails> employeeDetails = new ArrayList();
 		ResultSet rs = dbutils.ValidateLogin(email);
		
		while(rs.next())  {
			int employeeId = rs.getInt("id");
		
	    	List<EmployeeProject> empDetail = new ArrayList();
    			
		        		
		        			ResultSet empDetails = dbutils.GetEmployeeProjects(employeeId, rs.getString("role"));
		        			while(empDetails.next()) {
		        				
		        				String empEmail = empDetails.getString("email");
		        				String projectTemp = empDetails.getString("projectName");
		        				
		        				empDetail.add(new EmployeeProject(empEmail, projectTemp));
		        			}
		        			for(int i = 0; i < empDetail.size();i++) {
		        				System.out.println(empDetail.get(i));
		        			}
		        			System.out.println(empDetail);
		        			employeeDetails.add(new EmployeeDetails(rs.getInt("id"),rs.getString("email"),rs.getString("name"),rs.getString("password"),rs.getString("role"), empDetail));
		        			
		        		
		        		
		     }
		 
		
		System.out.println(employeeDetails);
		return(employeeDetails);
}
	
	
	
	

}
