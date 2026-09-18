package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillCategoryDto {
    private Long id;
    private String name;
    private String iconKey;
    private Boolean accent;
    private Integer displayOrder;
    private Boolean visible;
    private List<SkillDto> skills = new ArrayList<>();
}