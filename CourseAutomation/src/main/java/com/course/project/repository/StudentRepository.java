package com.course.project.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.course.project.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
