package com.courseEnrollmentSystem.crs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseEnrollmentSystem.crs.classes.Course;

public interface CourseRepository extends JpaRepository<Course, Long>  {

}
