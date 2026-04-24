package com.lxp.course.repository;

import com.lxp.course.model.Content;
import com.lxp.course.model.Course;
import com.lxp.course.model.Section;
import com.lxp.util.QueryUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                course.addSection(section);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(courseMap.values());
    }

    public String insert(Course insertCourse) {
        String courseSQL = QueryUtil.getQuery("course.courseInsert");
        String sectionSQL = QueryUtil.getQuery("course.sectionInsert");
        String contentSQL = QueryUtil.getQuery("course.contentInsert");

        Long courseId; // section , content에는 course_id에 맞는 넣어야하기 때문에
        try {
            courseId = 0L;
            try (PreparedStatement ps = connection.prepareStatement(courseSQL,
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, insertCourse.getCourseName());

                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (!rs.next()) {
                            throw new SQLException("강의 저장이 안됐습니다");
                        }
                        courseId = rs.getLong(1);
                    }
                }
            }
            for (Section section : insertCourse.getSections()) {
                String sectionName = section.getSectionName();

                Long sectionId = 0L;
                try (PreparedStatement ps = connection.prepareStatement(sectionSQL,
                        Statement.RETURN_GENERATED_KEYS)) {
                    ps.setLong(1, courseId);
                    ps.setString(2, sectionName);
                    ps.executeUpdate();

                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (!rs.next()) {
                            throw new SQLException("섹션 저장이 안됐습니다");
                        }
                        sectionId = rs.getLong(1);
                    }
                }

                for (Content content : section.getContents()) {
                    String contentName = content.getContentName();
                    String contentData = content.getContentData();
                    try (PreparedStatement ps = connection.prepareStatement(contentSQL,
                            Statement.RETURN_GENERATED_KEYS)) {
                        ps.setLong(1, courseId);
                        ps.setLong(2, sectionId);
                        ps.setString(3, contentName);
                        ps.setString(4, contentData);

                        int affectedRows = ps.executeUpdate();

                        if (affectedRows > 0) {
                            try (ResultSet rs = ps.getGeneratedKeys()) {
                                if (!rs.next()) {
                                    throw new SQLException("콘텐츠 저장이 안됐습니다");
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String result = insertCourse.getCourseName();
        return result;
    }
}
