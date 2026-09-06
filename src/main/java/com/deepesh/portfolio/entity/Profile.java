package com.deepesh.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Profile {
    @Id
    private Long id = 1L;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String email;
    private String location;
    private String githubUrl;
    private String linkedinUrl;
    private String resumeUrl;
}