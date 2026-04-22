package com.lxp.course.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Section {

    private Long sectionId;
    private Long courseId;
    private String sectionName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean isPublic;
    private boolean isDeleted;
    private List<Content> contents = new ArrayList<>();

    public Section() {
    }

    public void contentAdd(Content content) {
        if (this.contents == null) {
            this.contents = new ArrayList<>();
        }
        this.contents.add(content);
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
