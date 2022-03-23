package com.SkillMatrixMainFile.model;

public class EmployeeProject {
	private String email;
	private String projectName;
	public EmployeeProject(String email, String projectName) {
		super();
		this.email = email;
		this.projectName = projectName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}
