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
import com.course.project.model.CourseTime;
import com.course.project.service.CourseTimeService;

@RestController
@RequestMapping("/api")
public class CourseTimeController {

	private final CourseTimeService courseTimeService;

	@Autowired
	public CourseTimeController(CourseTimeService courseTimeService) {
		this.courseTimeService = courseTimeService;
	}

	@GetMapping("/courseTimeList")
	public ResponseEntity<List<CourseTime>> getCourseTimeList() {
		try {
			List<CourseTime> courseTimeList = courseTimeService.getCourseTimeList();
			if (courseTimeList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(courseTimeList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/courseTime/{id}")
	public ResponseEntity<CourseTime> getCourseTimeById(@PathVariable("id") String id) {
		Optional<CourseTime> courseTimeData = courseTimeService.getCourseTimeById(id);
		if (courseTimeData.isPresent()) {
			return new ResponseEntity<>(courseTimeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/courseTime")
	public ResponseEntity<CourseTime> saveCourseTime(@RequestBody CourseTime courseTime) {
		try {
			CourseTime _courseTime = courseTimeService
					.saveCourseTime(new CourseTime(courseTime.getWeekDay(), courseTime.getPeriod()));
			return new ResponseEntity<>(_courseTime, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/courseTime/{id}")
	public ResponseEntity<CourseTime> updateCourseTime(@PathVariable("id") String id,
			@RequestBody CourseTime courseTime) {
		Optional<CourseTime> courseTimeData = courseTimeService.getCourseTimeById(id);

		if (courseTimeData.isPresent()) {
			CourseTime _courseTime = courseTimeData.get();
			_courseTime.setWeekDay(courseTime.getWeekDay());
			_courseTime.setPeriod(courseTime.getPeriod());
			return new ResponseEntity<>(courseTimeService.updateCourseTime(_courseTime), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/courseTime/{id}")
	public ResponseEntity<HttpStatus> deleteCourseTime(@PathVariable("id") String id) {
		try {
			courseTimeService.deleteCourseTime(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
