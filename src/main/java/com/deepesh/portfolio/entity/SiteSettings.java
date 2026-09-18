package com.deepesh.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "site_settings")
public class SiteSettings {

    @Id
    private Long id = 1L;

    // Hero
    private String heroEyebrow;
    private String heroHeading;
    @Column(columnDefinition = "TEXT")
    private String heroSupportingText;
    private String heroPrimaryCtaLabel;
    private String heroPrimaryCtaTarget;
    private String heroSecondaryCtaLabel;
    private String heroSecondaryCtaTarget;
    private Boolean heroVisible = true;

    // Contact
    private String contactHeading;
    private String contactHeadline;
    private Boolean contactVisible = true;

    // Footer
    private String footerText;

    // Global
    private String siteName;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt = java.time.LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }
}
