package com.bootcoding.student.service;

import com.bootcoding.student.model.Course;
import com.bootcoding.student.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepo courseRepo;

    @Override
    public String addCourse(Course course) {
        return courseRepo.addCourse(course);
    }
}
