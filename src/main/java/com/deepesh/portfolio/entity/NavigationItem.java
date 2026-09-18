package com.deepesh.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "navigation_items")
public class NavigationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Label cannot be empty")
    private String label;

    @NotBlank(message = "Href cannot be empty")
    private String href;

    @Column(name = "display_order")
    private Integer displayOrder = 0;

    private Boolean visible = true;

    @Column(name = "is_external")
    private Boolean isExternal = false;

    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt = java.time.LocalDateTime.now();

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt = java.time.LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }
}
