package kacadej.henri.sistemmenaxhimistudent.repository;

import kacadej.henri.sistemmenaxhimistudent.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
