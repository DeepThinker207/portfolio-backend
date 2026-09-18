package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private String techStack;
    private String githubUrl;
    private String liveUrl;
    private Boolean visible;
    private Boolean featured;
    private Integer displayOrder;
    private String imageUrl;
    private List<HighlightDto> highlights = new ArrayList<>();
}