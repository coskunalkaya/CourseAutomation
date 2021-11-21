package com.course.project.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.project.model.StudentCourses;
import com.course.project.repository.StudentCoursesRepository;
import com.course.project.service.StudentCoursesService;

@Service
public class StudentCoursesServiceImpl implements StudentCoursesService{
	
	private final StudentCoursesRepository studentCoursesRepository; 
	
	@Autowired
	public StudentCoursesServiceImpl(StudentCoursesRepository studentCoursesRepository) {
		this.studentCoursesRepository = studentCoursesRepository;
	}

	@Override
	public List<StudentCourses> getStudentCoursesList() {
		List<StudentCourses> studentCoursesList = new ArrayList<StudentCourses>();
		studentCoursesRepository.findAll().forEach(studentCoursesList::add);
		return studentCoursesList;
	}
	
	@Override
	public Optional<StudentCourses> getStudentCoursesById(String id) {
		return studentCoursesRepository.findById(id);
	} 
	
	@Override
	public StudentCourses saveStudentCourses(StudentCourses studentCourses) {
		studentCoursesRepository.save(studentCourses);
		return studentCourses;
	}

	@Override
	public void deleteStudentCourses(String id) {
		studentCoursesRepository.deleteById(id);		
	}

	@Override
	public StudentCourses updateStudentCourses(StudentCourses studentCourses) {
		studentCoursesRepository.save(studentCourses);
		return studentCourses;
	}
}
