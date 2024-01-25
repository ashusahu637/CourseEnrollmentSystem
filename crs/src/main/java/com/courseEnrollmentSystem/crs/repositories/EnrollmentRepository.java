package com.courseEnrollmentSystem.crs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseEnrollmentSystem.crs.classes.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

}
