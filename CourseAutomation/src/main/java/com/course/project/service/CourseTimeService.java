package com.course.project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.course.project.model.CourseTime;

@Service
public interface CourseTimeService {
	public List<CourseTime> getCourseTimeList();
	public Optional<CourseTime> getCourseTimeById(String id);
	public CourseTime saveCourseTime(CourseTime courseTime);
	public void deleteCourseTime(String id);
	public CourseTime updateCourseTime(CourseTime courseTime);
}