package com.course.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.course.project.model.Teacher;

@Service
public interface TeacherService {
	public List<Teacher> getTeacherList();
	public Optional<Teacher> getTeacherById(String id);
	public Teacher saveTeacher(Teacher teacher);
	public void deleteTeacher(String id);
	public Teacher updateTeacher(Teacher teacher);

}
