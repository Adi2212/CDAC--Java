package com.iacsd.services;

import com.iacsd.exceptions.StudentException;

public interface SMServices {
    String enrollStudent(String studName, String studEmail, int studMarks, String course, String studAdmissionDate) throws StudentException;

    String cancelAdmission(String email) throws StudentException;

    void searchStudentByEmail(String email) throws StudentException;

    void listAllStudents();

    void listStudentByCourse(String course) throws StudentException;

    void printCourseCapacities();
}
