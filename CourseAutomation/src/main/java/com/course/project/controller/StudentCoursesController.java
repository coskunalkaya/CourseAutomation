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
import com.course.project.model.StudentCourses;
import com.course.project.service.StudentCoursesService;

@RestController
@RequestMapping("/api")
public class StudentCoursesController {

	private final StudentCoursesService studentCoursesService;

	@Autowired
	public StudentCoursesController(StudentCoursesService studentCoursesService) {
		this.studentCoursesService = studentCoursesService;
	}

	@GetMapping("/studentCoursesList")
	public ResponseEntity<List<StudentCourses>> getStudentCoursesList() {
		try {
			List<StudentCourses> studentCoursesList = studentCoursesService.getStudentCoursesList();
			if (studentCoursesList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(studentCoursesList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/studentCourses/{id}")
	public ResponseEntity<StudentCourses> getStudentCoursesById(@PathVariable("id") String id) {
		Optional<StudentCourses> studentCoursesData = studentCoursesService.getStudentCoursesById(id);
		if (studentCoursesData.isPresent()) {
			return new ResponseEntity<>(studentCoursesData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/studentCourses")
	public ResponseEntity<StudentCourses> saveStudentCourses(@RequestBody StudentCourses studentCourses) {
		try {
			StudentCourses _studentCourses = studentCoursesService
					.saveStudentCourses(new StudentCourses(studentCourses.getStudentId(), studentCourses.getCourseId()));
			return new ResponseEntity<>(_studentCourses, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/studentCourses/{id}")
	public ResponseEntity<StudentCourses> updateStudentCourses(@PathVariable("id") String id, @RequestBody StudentCourses studentCourses) {
		Optional<StudentCourses> StudentCoursesData = studentCoursesService.getStudentCoursesById(id);

		if (StudentCoursesData.isPresent()) {
			StudentCourses _studentCourses = StudentCoursesData.get();
			_studentCourses.setStudentId(studentCourses.getStudentId());
			_studentCourses.setCourseId(studentCourses.getCourseId());
			return new ResponseEntity<>(studentCoursesService.updateStudentCourses(_studentCourses), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/studentCourses/{id}")
	public ResponseEntity<HttpStatus> deleteStudentCourses(@PathVariable("id") String id) {
		try {
			studentCoursesService.deleteStudentCourses(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
