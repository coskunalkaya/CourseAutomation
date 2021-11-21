package com.course.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
public class Teacher {
	
	@Id
	private String id;	
	private String firstName;	
	private String lastName;	
	private String branch;
	
	public Teacher(String firstName, String lastName, String branch) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	
}
