package com.courseEnrollmentSystem.crs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseEnrollmentSystem.crs.classes.Course;
import com.courseEnrollmentSystem.crs.classes.Enrollment;
import com.courseEnrollmentSystem.crs.classes.Teacher;
import com.courseEnrollmentSystem.crs.repositories.CourseRepository;
import com.courseEnrollmentSystem.crs.repositories.EnrollmentRepository;
import com.courseEnrollmentSystem.crs.repositories.TeacherRepository;

@Service
public class TeacherService {

	  @Autowired
	    private TeacherRepository teacherRepository;
	  
	  @Autowired
	    private CourseRepository courseRepository;

	   @Autowired
	    private EnrollmentRepository enrollmentRepository;

	    public List<Teacher> getAllTeachers() {
	        return teacherRepository.findAll();
	    }
	    

		public void assignTeacherToCourse(Long teacherId, Long courseId) {
	    	 
	    	
	        Teacher teacher = teacherRepository.findById(teacherId)
	                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));

	        Course course = courseRepository.findById(courseId)
	                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

	        
	        if (teacher.getCourses().size() >= 5) {
	            throw new RuntimeException("Teacher is already assigned to the maximum number of courses.");
	        }

	        
	        if (isTeacherAssigned(course, teacher)) {
	            throw new RuntimeException("Teacher is already assigned to the course.");
	        }

	        
	        Enrollment enrollment = new Enrollment();
	        enrollment.setCourse(course);
	        enrollment.setTeacher(teacher);

	        
	        enrollmentRepository.save(enrollment);
	    }

	    private boolean isTeacherAssigned(Course course, Teacher teacher) {
	        
	        return course.getEnrollments().stream()
	                .anyMatch(enrollment -> enrollment.getTeacher().equals(teacher));
	    
	    	    }
	    
}
