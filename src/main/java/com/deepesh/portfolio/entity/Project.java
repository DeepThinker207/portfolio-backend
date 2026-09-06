package com.deepesh.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty") // Validation added
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description cannot be empty") // Validation added
    @Column(columnDefinition = "TEXT")
    private String description;

    private String techStack;

    private String githubUrl;

    private String liveUrl;
}