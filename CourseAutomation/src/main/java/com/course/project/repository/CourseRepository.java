package com.course.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.course.project.model.Course;

public interface CourseRepository extends MongoRepository<Course, String> {

}
