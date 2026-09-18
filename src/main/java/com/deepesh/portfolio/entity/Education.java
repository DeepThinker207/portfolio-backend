package com.deepesh.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "education")
public class Education {

    @Id
    private Long id = 1L;

    private String degree;
    private String fieldOfStudy;
    private String institution;
    private String graduationDate;
    private String graduationShort;
    private String location;
    private Integer displayOrder = 0;
    private Boolean visible = true;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt = java.time.LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }
}
