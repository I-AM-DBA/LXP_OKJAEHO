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

                            System.out.println(
                                    "강의 ID : " + courseId + "강의명 : " + courseName + "섹션명 : "
                                            + sectionName + "콘텐츠 명 : " + contentName + "콘텐츠 내용 : "
                                            + contentData);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void insertCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("저장할 정보가 없습니다");
        } else if (course.getCourseName() == null) {
            throw new IllegalArgumentException("강의 정보가 없습니다");
        } else if (course.getSections() == null) {
            throw new IllegalArgumentException("섹션 정보가 없습니다.");
        }
        for (Section section : course.getSections()) {
            if (section.getContents() == null) {
                throw new IllegalArgumentException("콘텐츠 정보가 없습니다.");
            }
        }
        try {
            String result = courseService.insertCourseAll(course);
            System.out.println("강의 등록 결과 : " + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
