package com.lxp.course.service;

import com.lxp.config.JDBCConnection;
import com.lxp.course.model.Course;
import com.lxp.course.repository.CourseRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;
    private final Connection connection;

    public CourseService() {
        try {
            this.connection = JDBCConnection.getConnection();
            this.courseRepository = new CourseRepository(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Course> courseFindAll() throws Exception {
        List<Course> courses = courseRepository.findAll();
        if (courses == null) {
            throw new Exception("강의를 조회하는데 실패했더요");
        } else {
            return courses;
        }
    }


    public Long courseInsert(String courseName, String sectionName, String contentName,
            String contentData) throws Exception {
        Long courses =
                courseRepository.courseInsert(courseName, sectionName, contentName, contentData);
        if (courses == null) {
            throw new Exception("강의를 입력하는데 실패했더요");
        } else {
            return courses;
        }

    }
}
