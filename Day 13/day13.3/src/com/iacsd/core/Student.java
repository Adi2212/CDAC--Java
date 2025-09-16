package com.iacsd.core;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
	// Student
//	-id (auto-incremented)
//	- name(string)
//	- email (unique)
//	- marks (int)
//	- course (enum)
//	- admissionDate(LocalDate)

	private int studId;
	private String studName;
	private String studEmail;
	private int studMarks;
	private PGCourse course;
	private LocalDate studAdmissionDate;
	private static int studCounter;

	static {
		studCounter = 100;
	}

	public Student(String studName, String studEmail, int studMarks, PGCourse course, LocalDate studAdmissionDate) {

		this.studId = ++studCounter;
		this.studName = studName;
		this.studEmail = studEmail;
		this.studMarks = studMarks;
		this.course = course;
		this.studAdmissionDate = studAdmissionDate;
	}

	public Student(String email) {
		this.studEmail = email;
	}

	public int getStudId() {
		return studId;
	}

	public String getStudName() {
		return studName;
	}

	public String getStudEmail() {
		return studEmail;
	}

	public int getStudMarks() {
		return studMarks;
	}

	public PGCourse getCourse() {
		return course;
	}

	public LocalDate getStudAdmitionDate() {
		return studAdmissionDate;
	}

	public static int getStudCounter() {
		return studCounter;
	}

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Email: %s | Marks: %d | Course: %s | Admission Date: %s",
                studId, studName, studEmail, studMarks, course, studAdmissionDate);
    }



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		return Objects.equals(studEmail, other.studEmail);
	}

}
