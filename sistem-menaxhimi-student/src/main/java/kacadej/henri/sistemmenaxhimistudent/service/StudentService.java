package kacadej.henri.sistemmenaxhimistudent.service;

import kacadej.henri.sistemmenaxhimistudent.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student updateStudent(Student student,Long id);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);
}
