package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private Long id;
    private String degree;
    private String fieldOfStudy;
    private String institution;
    private String graduationDate;
    private String graduationShort;
    private String location;
    private Integer displayOrder;
    private Boolean visible;
}