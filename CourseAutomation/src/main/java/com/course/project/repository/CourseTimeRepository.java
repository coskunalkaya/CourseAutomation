package com.course.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.course.project.model.CourseTime;

public interface CourseTimeRepository extends MongoRepository<CourseTime, String> {

}
