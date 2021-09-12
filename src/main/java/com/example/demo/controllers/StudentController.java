package com.example.demo.controllers;

import com.example.demo.student.Student;
import com.example.demo.student.StudentEmail;
import com.example.demo.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    @ResponseBody
    public Student addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }

    @GetMapping("/get")
    @ResponseBody
    public Student getStudent(@RequestBody StudentEmail email) {
        return studentService.getStudent(email.getEmail());

    }

    @PostMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
       Student newStudent =  studentService.updateStudentName(student);
       return newStudent;
    }
    @PostMapping("/delete")
    public void deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
    }

}
