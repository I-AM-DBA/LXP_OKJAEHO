package com.lxp.course.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private Long courseId;
    private String courseName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isPublic;
    private boolean isDeleted;
    private List<Section> sections = new ArrayList<>();

    public Course() {
    }

    public Course(String courseName, String sectionName, String contentName, String contentData) {
        this.courseName = courseName;

        Content content = new Content(contentName, contentData);
        Section section = new Section(sectionName);
        section.getContents().add(content);

        this.sections.add(section);

    }


    public void addSection(Section section) {
        if (this.sections == null) {
            this.sections = new ArrayList<>();
        }
        this.sections.add(section);
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}

