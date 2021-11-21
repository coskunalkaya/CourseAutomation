package com.course.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "student_courses")
public class StudentCourses {
	
	@Id
	private String id;
	private String studentId;
	private String courseId;
	
	public StudentCourses(String studentId, String courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	

}
