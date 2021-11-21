package com.course.project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.course.project.model.Course;

@Service
public interface CourseService {
	public List<Course> getCourseList();
	public Optional<Course> getCourseById(String id);
	public Course saveCourse(Course course);
	public void deleteCourse(String id);
	public Course updateCourse(Course cdourse);
}
