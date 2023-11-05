package com.bootcoding.student.controller;

import com.bootcoding.student.model.Student;
import com.bootcoding.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //-------insert record------
    @PostMapping("/student/insert")
    public String insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }


    //-------get all records-----
    @GetMapping("/student/get")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }


    //-------get records by id-----
    @GetMapping("/student/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    //-----update records------
    @PutMapping("/student/{s_id}")
    public String updateStudent(@PathVariable int s_id,@RequestBody Student student){
        return studentService.updateStudent(s_id,student);
    }

    //------delete records------
    @DeleteMapping("/student/{s_id}")
    public String deleteStudent(@PathVariable int s_id){
        return studentService.deleteStudent(s_id);
    }

}

