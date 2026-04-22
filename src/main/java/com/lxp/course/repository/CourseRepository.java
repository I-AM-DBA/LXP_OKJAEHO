package com.lxp.course.repository;

import com.lxp.course.model.Content;
import com.lxp.course.model.Course;
import com.lxp.course.model.Section;
import com.lxp.util.QueryUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CourseRepository {
    private final Connection connection;

    public CourseRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Course> findAll() {
        String sql = QueryUtil.getQuery("course.allSelect");
        Map<Long, Course> courseMap = new LinkedHashMap<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Long courseId = rs.getLong("course_id");

                Course course = new Course();
                course.setCourseId(courseId);
                course.setCourseName(rs.getString("course_name"));
                courseMap.put(courseId, course);

                Section section = new Section();
                section.setSectionName(rs.getString("section_name"));

                Content content = new Content();
                content.setContentName(rs.getString("content_name"));
                content.setContentData(rs.getString("content_data"));

                section.contentAdd(content);
                course.sectionAdd(section);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(courseMap.values());
    }
}
