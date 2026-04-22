package com.lxp.course.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    // 1. courses 테이블 관련
    private Long courseId;
    private String courseName;
    private String description;
    // LocalDateTime를 써야한다고 gpt가 그러는데 뭔지 몰라서 Long으로 합니다
    private Long createdAt;
    private Long updatedAt;
    private Long deleted_at;
    private boolean isPublic;
    private boolean isDeleted;
    private List<Section> sections = new ArrayList<>();

    public Course() {
    }

    public Course(Long courseId, String courseName, String description, Long createdAt,
            Long updatedAt, Long deleted_at, boolean isPublic, boolean isDeleted) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted_at = deleted_at;
        this.isPublic = isPublic;
        this.isDeleted = isDeleted;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Long deleted_at) {
        this.deleted_at = deleted_at;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

}

