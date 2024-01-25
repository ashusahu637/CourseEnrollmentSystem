package com.courseEnrollmentSystem.crs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseEnrollmentSystem.crs.classes.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	
}
