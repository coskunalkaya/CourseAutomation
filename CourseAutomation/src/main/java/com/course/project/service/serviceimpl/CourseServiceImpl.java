package com.course.project.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.project.model.Course;
import com.course.project.repository.CourseRepository;
import com.course.project.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	private final CourseRepository courseRepository; 
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public List<Course> getCourseList() {
		List<Course> courseList = new ArrayList<Course>();
		courseRepository.findAll().forEach(courseList::add);
		return courseList;
	}
	
	@Override
	public Optional<Course> getCourseById(String id) {
		return courseRepository.findById(id);
	} 
	
	@Override
	public Course saveCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);		
	}

	@Override
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
	}
}

