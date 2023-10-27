package com.bootcoding.student.controller;

import com.bootcoding.student.model.Course;
import com.bootcoding.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    //------Add courses----
    @PostMapping("/course")
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }
}
