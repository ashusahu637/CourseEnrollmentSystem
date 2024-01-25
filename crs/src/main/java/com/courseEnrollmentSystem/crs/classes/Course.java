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

@Entity
@Data
@Table
public class Course {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long courseId;
	    
	    @Column(name = "course_name")
	    private String courseName;
	    
	    @Column(name = "maxstudent")
	    private int maxStudents;

	    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	    private List<Enrollment> enrollments = new ArrayList<>();

		public List<Enrollment> getEnrollments() {
			return enrollments;
		}

		public void setEnrollments(List<Enrollment> enrollments) {
			this.enrollments = enrollments;
		}

		public int getMaxStudents() {
			return maxStudents;
		}

		public void setMaxStudents(int maxStudents) {
			this.maxStudents = maxStudents;
		}
	    
	    
}
