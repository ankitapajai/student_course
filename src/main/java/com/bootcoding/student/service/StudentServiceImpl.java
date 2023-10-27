package com.bootcoding.student.service;

import com.bootcoding.student.model.Student;
import com.bootcoding.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public String insertStudent(Student student) {
        return studentRepo.insertStudent(student);
    }


    @Override
    public List<Student> getStudent() {
        return studentRepo.getStudent();
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    public String updateStudent(int s_id, Student student) {
        return studentRepo.updateStudent(s_id,student);
    }

    @Override
    public String deleteStudent(int s_id) {
        return studentRepo.deleteStudent(s_id);
    }
}


