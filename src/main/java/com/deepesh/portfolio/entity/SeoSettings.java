package com.deepesh.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "seo_settings")
public class SeoSettings {

    @Id
    private Long id = 1L;

    private String pageTitle;
    private String metaDescription;
    private String ogTitle;
    private String ogDescription;
    private String ogImageUrl;
    private String twitterTitle;
    private String twitterDescription;
    private String robots = "index, follow";

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt = java.time.LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }
}
