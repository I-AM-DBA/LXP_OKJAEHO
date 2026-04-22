package com.lxp.course.model;

import java.util.ArrayList;
import java.util.List;

public class Section {

    // 2. sections 테이블 관련
    private Long sectionId;
    private Long courseId;
    private String sectionName;
    private Long createdAt;
    private Long updatedAt;
    private Long deleted_at;
    private boolean isPublic;
    private boolean isDeleted;
    private List<Content> contents = new ArrayList<>();

    public Section() {
    }

    public Section(Long sectionId, Long courseId, String sectionName, Long createdAt,
            Long updatedAt, Long deleted_at, boolean isPublic, boolean isDeleted) {
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.sectionName = sectionName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted_at = deleted_at;
        this.isPublic = isPublic;
        this.isDeleted = isDeleted;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
