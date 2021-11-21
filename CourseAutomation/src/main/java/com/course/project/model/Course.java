package com.course.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "course")

public class Course {
	
	@Id
	private String id;
	private String teacherId;
	private String courseTimeId;
	private String name;
	private String description;
	
	public Course(String teacherId, String courseTimeId, String name, String description) {
		super();
		this.teacherId = teacherId;
		this.courseTimeId = courseTimeId;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getCourseTimeId() {
		return courseTimeId;
	}
	public void setCourseTimeId(String courseTimeId) {
		this.courseTimeId = courseTimeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
