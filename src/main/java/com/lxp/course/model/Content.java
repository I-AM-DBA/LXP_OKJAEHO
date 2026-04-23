package com.lxp.course.model;

import java.time.LocalDateTime;

public class Content {

    private Long contentId;
    private Long sectionId;
    private Long courseId;
    private String contentName;
    private String contentData;
    private Long contentTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isPublic;
    private boolean isDeleted;
    private boolean isFree;

    public Content() {
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
}
