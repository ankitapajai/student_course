package com.bootcoding.student.service;

import com.bootcoding.student.model.Student;

import java.util.List;

public interface StudentService {

    String insertStudent(Student student);

    List<Student> getStudent();

    Student getById(int id);

    String updateStudent(int s_id, Student student);

    String deleteStudent(int s_id);

}
