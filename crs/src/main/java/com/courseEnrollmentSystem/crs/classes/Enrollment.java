package com.courseEnrollmentSystem.crs.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table
public class Enrollment {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long enrollmentId;

	    @ManyToOne
	    @JoinColumn(name = "course_id")
	    private Course course;

	    @ManyToOne
	    @JoinColumn(name = "teacher_id")
	    private Teacher teacher;

	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private Student student;

		public Long getEnrollmentId() {
			return enrollmentId;
		}

		public void setEnrollmentId(Long enrollmentId) {
			this.enrollmentId = enrollmentId;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		public Teacher getTeacher() {
			return teacher;
		}

		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}
	    
	    

}
