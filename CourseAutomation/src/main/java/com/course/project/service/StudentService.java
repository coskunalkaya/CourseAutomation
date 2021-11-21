package com.course.project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.course.project.model.Student;

@Service
public interface StudentService {
	public List<Student> getStudentList();
	public Optional<Student> getStudentById(String id);
	public Student saveStudent(Student student);
	public void deleteStudent(String id);
	public Student updateStudent(Student student);
}
