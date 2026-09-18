package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FocusItemDto {
    private Long id;
    private String label;
    private Integer displayOrder;
    private Boolean visible;
}