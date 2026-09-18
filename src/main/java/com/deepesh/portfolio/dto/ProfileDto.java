package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private Long id;
    private String name;
    private String bio;
    private String email;
    private String location;
    private String githubUrl;
    private String linkedinUrl;
    private String resumeUrl;
    private String roleTitle;
    private Boolean availabilityEnabled;
    private String availabilityLabel;
}