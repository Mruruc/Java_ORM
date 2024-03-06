package com.mruruc.models;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
@MappedSuperclass
public class BaseEntity {
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private String createdBy;
    private String lastModified;

    public BaseEntity() {}

    public BaseEntity(LocalDateTime createdAt,
                      LocalDateTime lastModifiedAt,
                      String createdBy,
                      String lastModified) {
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                ", createdBy='" + createdBy + '\'' +
                ", lastModified='" + lastModified + '\'' +
                '}';
    }
}
