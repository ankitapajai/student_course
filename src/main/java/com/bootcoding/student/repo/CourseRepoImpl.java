package com.bootcoding.student.repo;

import com.bootcoding.student.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CourseRepoImpl implements CourseRepo{

    private  DataSource dataSource;
    private  JdbcTemplate jdbcTemplate;

    // Constructor Injection
    public CourseRepoImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public String addCourse(Course course) {
        try{

            String query = "INSERT into course(course_name)" + " values (?)";
            jdbcTemplate.update(query, course.getCourse_name());
            return "Course inserted successfully...";

        }catch (Exception ex){
            ex.printStackTrace();
            return "Course not inserted....";
        }
    }
}
