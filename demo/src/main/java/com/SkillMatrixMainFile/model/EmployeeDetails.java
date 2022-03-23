package com.SkillMatrixMainFile.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetails {
	private int id;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	private String password;
	private String role ;
	private List<EmployeeProject> projects = new ArrayList();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List getProjects() {
		return projects;
	}
	public void setProjects(List projects) {
		this.projects = projects;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public EmployeeDetails(int id, String email, String name, String password, String role, List projects) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.projects = projects;
	}
	
}

