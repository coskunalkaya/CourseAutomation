
package com.course.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.course.project.model.StudentCourses;

public interface StudentCoursesRepository extends MongoRepository<StudentCourses, String> {

}
