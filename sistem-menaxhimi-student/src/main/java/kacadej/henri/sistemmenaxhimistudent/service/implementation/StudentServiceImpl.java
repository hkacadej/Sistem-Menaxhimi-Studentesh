package kacadej.henri.sistemmenaxhimistudent.service.implementation;

import kacadej.henri.sistemmenaxhimistudent.entity.Student;
import kacadej.henri.sistemmenaxhimistudent.repository.StudentRepository;
import kacadej.henri.sistemmenaxhimistudent.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }



    @Override
    public Student updateStudent(Student student, Long id) {
        Student existing = studentRepository.findById(id).get();
        existing.setId(id);
        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());
        saveStudent(existing);
        return existing;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
