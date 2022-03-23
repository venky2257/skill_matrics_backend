package com.SkillMatrixMainFile.model;

public class EmployeeBasicDetails {
	private int id;
	private String email;
	
	private String name;
	
	private String role ;
	
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
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public EmployeeBasicDetails(int id, String email, String name, String role) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;

		this.role = role;
		
	}
}
