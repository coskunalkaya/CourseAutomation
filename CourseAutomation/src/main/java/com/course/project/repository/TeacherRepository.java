package com.course.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.course.project.model.Teacher;


public interface TeacherRepository extends MongoRepository<Teacher, String>{

}
