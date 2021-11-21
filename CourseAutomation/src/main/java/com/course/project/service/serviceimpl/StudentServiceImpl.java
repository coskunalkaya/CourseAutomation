package com.course.project.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.project.model.Student;
import com.course.project.repository.StudentRepository;
import com.course.project.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private final StudentRepository studentRepository; 
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		studentRepository.findAll().forEach(studentList::add);
		return studentList;
	}
	
	@Override
	public Optional<Student> getStudentById(String id) {
		return studentRepository.findById(id);
	} 
	
	@Override
	public Student saveStudent(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Override
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);		
	}

	@Override
	public Student updateStudent(Student student) {
		studentRepository.save(student);
		return student;
	}
}
