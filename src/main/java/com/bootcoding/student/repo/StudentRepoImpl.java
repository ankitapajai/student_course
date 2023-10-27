package com.bootcoding.student.repo;

import com.bootcoding.student.model.Course;
import com.bootcoding.student.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepoImpl implements StudentRepo {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public StudentRepoImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String insertStudent(Student student) {
        try {
            String query = "insert into student(s_name,s_branch,s_age,s_phone) values('" + student.getS_name() + "', '"
                    + student.getS_branch() + "', "
                    + student.getS_age() + ", '"
                    + student.getS_phone()+ "')";
            jdbcTemplate.update(query);

            int studentId = getIdByQuery(student);
            System.out.println(studentId);

            mapCourse(student, studentId);
            return "student data inserted successfully!";

        } catch (Exception ex) {
            ex.printStackTrace();
            return "student data doesn't inserted....";
        }
    }

    private void mapCourse(Student student, int studentId) {
        String query = "insert into course(course_name,s_id)" + " values(?,?)";
        for(Course course: student.getCourseList()) {
            jdbcTemplate.update(query, course.getCourse_name(), studentId);
        }
    }

    private int getIdByQuery(Student student) {
        String selectStudentIdQuery = "select s_id from student where s_name = ?";
        int studentId = jdbcTemplate.queryForObject(selectStudentIdQuery, int.class, student.getS_name());
        return studentId;
    }


            public List<Student> getStudent () {
                try {

                    String sql = "select * from student";
                    return jdbcTemplate.query(sql, new RowMapper<Student>() {
                        @Override
                        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Student student = new Student();
                            student.setS_id(rs.getInt("s_id"));
                            student.setS_name(rs.getString("s_name"));
                            student.setS_branch(rs.getString("s_branch"));
                            student.setS_age(rs.getInt("s_age"));
                            student.setS_phone(rs.getLong("s_phone"));
                            return student;
                        }
                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            //------get records by id-----

            public Student getById ( int id){
                try {

                    String sql = "select * from student where s_id = " + id + "";
                    return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
                        @Override
                        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Student student = new Student();
                            student.setS_id(rs.getInt("s_id"));
                            student.setS_name(rs.getString("s_name"));
                            student.setS_branch(rs.getString("s_branch"));
                            student.setS_age(rs.getInt("s_age"));
                            student.setS_phone(rs.getLong("s_phone"));
                            return student;
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            //-------update records------

            public String updateStudent ( int s_id, Student student){
                try {
                    String sql = "UPDATE student SET s_id=?,s_name=?,s_branch=?,s_age=?,s_phone=? where s_id=?";
                    jdbcTemplate.update(sql, student.getS_id(), student.getS_name(), student.getS_branch(),
                            student.getS_age(), student.getS_phone(), s_id);
                    return "student updated..";
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return "student not updated...";
                }

            }


            //--------delete records-----

            public String deleteStudent ( int s_id){
                try {
                    String sql = "delete from student where s_id=?";
                    jdbcTemplate.update(sql, s_id);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return "delete message..";
            }
        }


