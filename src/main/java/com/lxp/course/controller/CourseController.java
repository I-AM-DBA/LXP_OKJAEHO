package com.lxp.course.controller;

import com.lxp.course.model.Content;
import com.lxp.course.model.Course;
import com.lxp.course.model.Section;
import com.lxp.course.service.CourseService;
import java.util.List;

public class CourseController {
    private CourseService courseService = new CourseService();

    public void allComeOn() {
        try {
            List<Course> courses = courseService.courseFindAll();
            if (courses.isEmpty()) {
                System.out.println("커리큘럼이 없습니다 ㅠㅠ");
            } else {
                for (Course course : courses) {
                    Long courseId = course.getCourseId();
                    String courseName = course.getCourseName();

                    for (Section section : course.getSections()) {
                        String sectionName = section.getSectionName();

                        for (Content content : section.getContents()) {
                            String contentName = content.getContentName();
                            String contentData = content.getContentData();

                            System.out.println(courseId + courseName + sectionName + contentName
                                    + contentData);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void courseInsert(String courseName, String sectionName, String contentName,
            String contentData) throws Exception {
        Long courses =
                courseService.courseInsert(courseName, sectionName, contentName, contentData);


    }
}
