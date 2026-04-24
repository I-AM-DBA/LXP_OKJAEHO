package com.lxp.course.service;

import com.lxp.config.JDBCConnection;
import com.lxp.course.model.Content;
import com.lxp.course.model.Course;
import com.lxp.course.model.Section;
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

    public String insertCourseAll(Course course) throws Exception {
        // 강의 이름이 같으면 등록되지 않는 검증
        List<Course> courses = courseRepository.findAll();
        for (Course selectCourse : courses) {
            if (selectCourse.getCourseName().equals(course.getCourseName())) {
                throw new Exception();
            }
        }
        // 입력을 진행하는 과정?
        String result = null;
        for (Section section : course.getSections()) {
            String sectionName = section.getSectionName();

            for (Content content : section.getContents()) {
                String contentName = content.getContentName();
                String contentData = content.getContentData();

                Course insertCourse =
                        new Course(course.getCourseName(), sectionName, contentName, contentData);
                result = courseRepository.insert(insertCourse);
            }
        }
        return result;
    }
}
