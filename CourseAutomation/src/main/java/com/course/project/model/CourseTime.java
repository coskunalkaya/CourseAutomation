package com.course.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "course_time")
public class CourseTime {	
	
	@Id
	private String id;	
	private int weekDay;
	private String period;
	
	public CourseTime(int weekDay, String period) {
		this.weekDay = weekDay;
		this.period = period;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	
	
}
