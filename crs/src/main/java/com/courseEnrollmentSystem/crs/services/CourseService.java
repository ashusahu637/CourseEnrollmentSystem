package com.courseEnrollmentSystem.crs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseEnrollmentSystem.crs.classes.Course;
import com.courseEnrollmentSystem.crs.classes.Enrollment;
import com.courseEnrollmentSystem.crs.classes.Student;
import com.courseEnrollmentSystem.crs.repositories.CourseRepository;
import com.courseEnrollmentSystem.crs.repositories.EnrollmentRepository;
import com.courseEnrollmentSystem.crs.repositories.StudentRepository;

@Service
public class CourseService {

	 @Autowired
	 private CourseRepository courseRepository;
	 
	 @Autowired
	 private StudentRepository studentRepository;
	 
	 @Autowired
	 private EnrollmentRepository enrollmentRepository;

	    public List<Course> getAllCourses() {
	        return courseRepository.findAll();
	    }

	    public void enrollStudent(Long courseId, Long studentId) {
	    	 Course course = courseRepository.findById(courseId)
	                 .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

	         Student student = studentRepository.findById(studentId)
	                 .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

	         
	         if (course.getEnrollments().size() >= course.getMaxStudents()) {
	             throw new RuntimeException("Course is full. Cannot enroll more students.");
	         }

	    
	         if (isStudentEnrolled(course, student)) {
	             throw new RuntimeException("Student is already enrolled in the course.");
	         }

	         
	         Enrollment enrollment = new Enrollment();
	         enrollment.setCourse(course);
	         enrollment.setStudent(student);

	         
	         enrollmentRepository.save(enrollment);
	     }
	    
	    private boolean isStudentEnrolled(Course course, Student student) {
	        
	        return course.getEnrollments().stream()
	                .anyMatch(enrollment -> enrollment.getStudent().equals(student));
	    }

	    public void removeStudent(Long courseId, Long studentId) {
	    	 
	        Course course = courseRepository.findById(courseId)
	                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

	        Student student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

	        
	        Enrollment enrollment = findEnrollment(course, student);

	        if (enrollment == null) {
	            throw new RuntimeException("Student is not enrolled in the course.");
	        }

	        
	        course.getEnrollments().remove(enrollment);
	        
	        courseRepository.save(course);

	        enrollmentRepository.delete(enrollment);
	    }

	    private Enrollment findEnrollment(Course course, Student student) {
	        
	        return course.getEnrollments().stream()
	                .filter(e -> e.getStudent().equals(student))
	                .findFirst()
	                .orElse(null);
	    }
}

