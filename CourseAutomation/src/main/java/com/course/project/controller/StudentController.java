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
import com.course.project.model.Student;
import com.course.project.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/studentList")
	public ResponseEntity<List<Student>> getStudentList() {
		try {
			List<Student> studentList = studentService.getStudentList();
			if (studentList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(studentList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") String id) {
		Optional<Student> studentData = studentService.getStudentById(id);
		if (studentData.isPresent()) {
			return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		try {
			Student _student = studentService
					.saveStudent(new Student(student.getFirstName(), student.getLastName(), student.getAddress()));
			return new ResponseEntity<>(_student, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
		Optional<Student> studentData = studentService.getStudentById(id);

		if (studentData.isPresent()) {
			Student _student = studentData.get();
			_student.setFirstName(student.getFirstName());
			_student.setLastName(student.getLastName());
			_student.setAddress(student.getAddress());
			return new ResponseEntity<>(studentService.updateStudent(_student), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") String id) {
		try {
			studentService.deleteStudent(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
