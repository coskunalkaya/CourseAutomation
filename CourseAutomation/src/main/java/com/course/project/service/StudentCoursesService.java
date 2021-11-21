package com.course.project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.course.project.model.StudentCourses;

@Service
public interface StudentCoursesService {
	public List<StudentCourses> getStudentCoursesList();
	public Optional<StudentCourses> getStudentCoursesById(String id);
	public StudentCourses saveStudentCourses(StudentCourses studentCourses);
	public void deleteStudentCourses(String id);
	public StudentCourses updateStudentCourses(StudentCourses studentCourses);
}
