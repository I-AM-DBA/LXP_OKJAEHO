package com.lxp.course.model;

public class Content {
    // 3. contents 테이블 관련
    private Long contentId;
    private Long sectionId;
    private Long courseId;
    private String contentName;
    private String contentData;
    private Long contentTime;
    private Long createdAt;
    private Long updatedAt;
    private Long deleted_at;
    private boolean isPublic;
    private boolean isDeleted;
    private boolean isFree;

    public Content() {
    }

    public Content(Long contentId, Long sectionId, Long courseId, String contentName,
            String contentData, Long contentTime, Long createdAt, Long updatedAt, Long deleted_at,
            boolean isPublic, boolean isDeleted, boolean isFree) {
        this.contentId = contentId;
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.contentName = contentName;
        this.contentData = contentData;
        this.contentTime = contentTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted_at = deleted_at;
        this.isPublic = isPublic;
        this.isDeleted = isDeleted;
        this.isFree = isFree;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
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

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentData() {
        return contentData;
    }

    public void setContentData(String contentData) {
        this.contentData = contentData;
    }

    public Long getContentTime() {
        return contentTime;
    }

    public void setContentTime(Long contentTime) {
        this.contentTime = contentTime;
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

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
