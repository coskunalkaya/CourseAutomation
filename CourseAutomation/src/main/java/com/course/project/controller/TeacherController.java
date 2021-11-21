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
import com.course.project.model.Teacher;
import com.course.project.service.TeacherService;

@RestController
@RequestMapping("/api")
public class TeacherController {
	
	private final TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@GetMapping("/teacherList")
	public ResponseEntity<List<Teacher>> getTeacherList() {
		try {
			List<Teacher> teacherList = teacherService.getTeacherList();
			if (teacherList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(teacherList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/teacher/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") String id) {
		Optional<Teacher> teacherData = teacherService.getTeacherById(id);
		if (teacherData.isPresent()) {
			return new ResponseEntity<>(teacherData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/teacher")
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
		try {
			Teacher _teacher = teacherService
					.saveTeacher(new Teacher(teacher.getFirstName(), teacher.getLastName(), teacher.getBranch()));
			return new ResponseEntity<>(_teacher, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/teacher/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") String id, @RequestBody Teacher teacher) {
		Optional<Teacher> teacherData = teacherService.getTeacherById(id);

		if (teacherData.isPresent()) {
			Teacher _teacher = teacherData.get();
			_teacher.setFirstName(teacher.getFirstName());
			_teacher.setLastName(teacher.getLastName());
			_teacher.setBranch(teacher.getBranch());
			return new ResponseEntity<>(teacherService.updateTeacher(_teacher), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable("id") String id) {
		try {
			teacherService.deleteTeacher(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
