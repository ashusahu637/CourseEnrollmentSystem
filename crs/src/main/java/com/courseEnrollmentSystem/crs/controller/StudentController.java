package com.courseEnrollmentSystem.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseEnrollmentSystem.crs.classes.Student;
import com.courseEnrollmentSystem.crs.services.StudentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/students")
	public class StudentController {
	    @Autowired
	    private StudentService studentService;

	    @GetMapping
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    @PostMapping("/{studentId}/enroll/{courseId}")
	    public void enrollInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
	        studentService.enrollInCourse(studentId, courseId);
	    }

	    @PostMapping("/{studentId}/withdraw/{courseId}")
	    public void withdrawFromCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
	        studentService.withdrawFromCourse(studentId, courseId);
	   }
}


