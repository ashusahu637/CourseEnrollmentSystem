package com.courseEnrollmentSystem.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseEnrollmentSystem.crs.classes.Teacher;
import com.courseEnrollmentSystem.crs.services.TeacherService;

@CrossOrigin("*")
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping("/{teacherId}/assign/{courseId}")
    public void assignTeacherToCourse(@PathVariable Long teacherId, @PathVariable Long courseId) {
        teacherService.assignTeacherToCourse(teacherId, courseId);
    }
}