package com.iacsd.services;

import static com.iacsd.services.SMValidations.validateAllInput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.iacsd.core.PGCourse;
import com.iacsd.core.Student;
import com.iacsd.exceptions.StudentException;
import com.iacsd.exceptions.StudentNotFoundException;

public class SMServicesImpl implements SMServices {
    private final List<Student> students;

    public SMServicesImpl() {
        students = new ArrayList<>();
    }

    @Override
    public String enrollStudent(String studName, String studEmail, int studMarks, String course,
                                String studAdmissionDate) throws StudentException {
        Student sdt = validateAllInput(studName, studEmail, studMarks, course, studAdmissionDate, students);
        if (!sdt.getCourse().allocateSeat())
            throw new StudentException("Course capacity is full, try another course.");
        students.add(sdt);
        return sdt.getStudName() + " enrolled successfully";
    }

    @Override
    public String cancelAdmission(String email) throws StudentException {
        Student temp = new Student(email);
        int index = students.indexOf(temp);
        if (index == -1)
            throw new StudentNotFoundException("Student with email " + email + " not found.");
        students.get(index).getCourse().freeSeat();
        students.remove(index);
        return "Admission cancelled for " + email;
    }

    @Override
    public void searchStudentByEmail(String email) throws StudentException {
        Student temp = new Student(email);
        int index = students.indexOf(temp);
        if (index == -1)
            throw new StudentNotFoundException("Student with email " + email + " not found.");
        System.out.println(students.get(index));
    }

    @Override
    public void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students admitted yet!");
            return;
        }
        students.forEach(System.out::println);
    }

    @Override
    public void listStudentByCourse(String course) throws StudentException {
        PGCourse selectedCourse = PGCourse.valueOf(course.toUpperCase());
        boolean found = false;
        for (Student s : students) {
            if (s.getCourse() == selectedCourse) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students admitted in " + selectedCourse.name());
        }
    }

    public void printCourseCapacities() {
        System.out.println("\n--- Course Capacities ---");
        for (PGCourse course : PGCourse.values()) {
            System.out.println(course.name() + " | Min Marks: " + course.getMinMarks()
                    + " | Total Seats: " + course.getMaxCapacity()
                    + " | Available: " + course.getAvailableSeats());
        }
    }
}
