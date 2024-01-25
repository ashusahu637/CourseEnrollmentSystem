package com.courseEnrollmentSystem.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseEnrollmentSystem.crs.classes.Course;
import com.courseEnrollmentSystem.crs.classes.Student;
import com.courseEnrollmentSystem.crs.classes.Teacher;
import com.courseEnrollmentSystem.crs.services.CourseService;
import com.courseEnrollmentSystem.crs.services.StudentService;
import com.courseEnrollmentSystem.crs.services.TeacherService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminContoller {

		@Autowired
	    private CourseService courseService;
	    
	    @Autowired
	    private TeacherService teacherService;
	    
	    @Autowired
	    private StudentService studentService;

	    @GetMapping("/courses")
	    public List<Course> getAllCourses() {
	        return courseService.getAllCourses();
	    }

	    @GetMapping("/teachers")
	    public List<Teacher> getAllTeachers() {
	        return teacherService.getAllTeachers();
	    }

	    @GetMapping("/students")
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

}
