package kacadej.henri.sistemmenaxhimistudent.controller;

import kacadej.henri.sistemmenaxhimistudent.entity.Student;
import kacadej.henri.sistemmenaxhimistudent.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listaStudent(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public  String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String updateStudentForm(@PathVariable Long id , Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id ,
                                @ModelAttribute("student") Student student,
                                Model model){
        studentService.updateStudent(student,id);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
