package com.deepesh.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "social_links")
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Platform cannot be empty")
    private String platform;

    @NotBlank(message = "Label cannot be empty")
    private String label;

    @NotBlank(message = "URL cannot be empty")
    private String url;

    @Column(name = "icon_key")
    private String iconKey;

    @Column(name = "display_order")
    private Integer displayOrder = 0;

    private Boolean visible = true;

    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt = java.time.LocalDateTime.now();

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt = java.time.LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }
}
