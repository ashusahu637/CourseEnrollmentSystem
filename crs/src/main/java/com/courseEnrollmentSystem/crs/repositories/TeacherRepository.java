package com.courseEnrollmentSystem.crs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseEnrollmentSystem.crs.classes.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
