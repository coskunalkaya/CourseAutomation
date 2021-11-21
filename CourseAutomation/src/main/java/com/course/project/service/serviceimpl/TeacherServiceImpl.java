package com.course.project.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.project.model.Teacher;
import com.course.project.repository.TeacherRepository;
import com.course.project.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	private final TeacherRepository teacherRepository; 
	
	@Autowired
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}
	
	@Override
	public List<Teacher> getTeacherList() {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherRepository.findAll().forEach(teacherList::add);
		return teacherList;
	}
	
	@Override
	public Optional<Teacher> getTeacherById(String id) {
		return teacherRepository.findById(id);
	} 
	
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
		return teacher;
	}

	@Override
	public void deleteTeacher(String id) {
		teacherRepository.deleteById(id);		
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
		return teacher;
	}

}
