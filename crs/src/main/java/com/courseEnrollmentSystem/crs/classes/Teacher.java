package com.courseEnrollmentSystem.crs.classes;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Teacher {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

	@Column(name = "teacher_name")
    private String teacherName;
	
	private List<Course> courses;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	    
    
}
