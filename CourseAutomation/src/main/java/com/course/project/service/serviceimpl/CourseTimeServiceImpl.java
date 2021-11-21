package com.course.project.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.project.model.CourseTime;
import com.course.project.repository.CourseTimeRepository;
import com.course.project.service.CourseTimeService;

@Service
public class CourseTimeServiceImpl implements CourseTimeService {

	private final CourseTimeRepository courseTimeRepository;

	@Autowired
	public CourseTimeServiceImpl(CourseTimeRepository CourseTimeRepository) {
		this.courseTimeRepository = CourseTimeRepository;
	}

	@Override
	public List<CourseTime> getCourseTimeList() {
		List<CourseTime> CourseTimeList = new ArrayList<CourseTime>();
		courseTimeRepository.findAll().forEach(CourseTimeList::add);
		return CourseTimeList;
	}

	@Override
	public Optional<CourseTime> getCourseTimeById(String id) {
		return courseTimeRepository.findById(id);
	}

	@Override
	public CourseTime saveCourseTime(CourseTime CourseTime) {
		courseTimeRepository.save(CourseTime);
		return CourseTime;
	}

	@Override
	public void deleteCourseTime(String id) {
		courseTimeRepository.deleteById(id);
	}

	@Override
	public CourseTime updateCourseTime(CourseTime CourseTime) {
		courseTimeRepository.save(CourseTime);
		return CourseTime;
	}
}
