package com.course.project.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.course.project.model.Course;
import com.course.project.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	private final CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping("/courseList")
	public ResponseEntity<List<Course>> getCourseList() {
		try {
			List<Course> courseList = courseService.getCourseList();
			if (courseList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(courseList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") String id) {
		Optional<Course> courseData = courseService.getCourseById(id);
		if (courseData.isPresent()) {
			return new ResponseEntity<>(courseData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/course")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		try {
			Course _course = courseService
					.saveCourse(new Course(course.getName(), course.getDescription(), course.getTeacherId(), course.getCourseTimeId()));
			return new ResponseEntity<>(_course, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/course/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") String id, @RequestBody Course course) {
		Optional<Course> courseData = courseService.getCourseById(id);

		if (courseData.isPresent()) {
			Course _course = courseData.get();
			_course.setName(course.getName());
			_course.setDescription(course.getDescription());
			_course.setTeacherId(course.getTeacherId());
			_course.setCourseTimeId(course.getCourseTimeId());
			return new ResponseEntity<>(courseService.updateCourse(_course), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/course/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") String id) {
		try {
			courseService.deleteCourse(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
