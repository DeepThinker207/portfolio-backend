package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildAreaDto {
    private Long id;
    private String title;
    private String description;
    private String iconKey;
    private Integer displayOrder;
    private Boolean visible;
}