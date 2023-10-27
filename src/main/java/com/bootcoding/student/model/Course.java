package com.bootcoding.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
  private int course_id;
  private String course_name;


  public Course(String courseList) {
    this.setCourse_name(courseList);
  }

}
