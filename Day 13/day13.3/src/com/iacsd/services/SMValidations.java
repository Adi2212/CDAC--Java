package com.iacsd.services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.iacsd.core.PGCourse;
import com.iacsd.core.Student;
import com.iacsd.exceptions.*;

public class SMValidations {

    public static Student validateAllInput(String studName, String studEmail, int studMarks, String course,
                                           String studAdmissionDate, List<Student> students) throws StudentException {
        validateEmail(studEmail);
        validateStudent(studEmail, students);
        PGCourse selectedCourse = validateCourseMarksAndCapacity(course, studMarks);
        LocalDate date = validateDate(studAdmissionDate);
        return new Student(studName, studEmail, studMarks, selectedCourse, date);
    }

    public static void validateStudent(String studEmail, List<Student> students) throws DuplicateStudentException {
        Student temp = new Student(studEmail);
        if (students.contains(temp))
            throw new DuplicateStudentException("Student with email " + studEmail + " already exists.");
    }

    public static void validateEmail(String studEmail) throws InvalidEmailException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!studEmail.matches(regex))
            throw new InvalidEmailException("Invalid email format: " + studEmail);
    }

    public static PGCourse validateCourseMarksAndCapacity(String course, int studMarks) throws StudentException {
        PGCourse selectedCourse = PGCourse.valueOf(course.toUpperCase());

        if (studMarks < selectedCourse.getMinMarks()) {
            throw new InsufficientMarksException(
                    "Marks " + studMarks + " are below required " + selectedCourse.getMinMarks());
        }

        if (selectedCourse.getAvailableSeats() <= 0) {
            throw new CourseFullException("No seats available in " + selectedCourse.name());
        }
        return selectedCourse;
    }

    public static LocalDate validateDate(String studAdmissionDate) throws InvalidDateException {
        try {
            LocalDate date = LocalDate.parse(studAdmissionDate);
            if (date.isAfter(LocalDate.now())) {
                throw new InvalidDateException("Admission date cannot be in the future: " + studAdmissionDate);
            }
            return date;
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Invalid date format. Use yyyy-MM-dd");
        }
    }
}
