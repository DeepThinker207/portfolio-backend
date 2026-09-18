package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NavigationItemDto {
    private Long id;
    private String label;
    private String href;
    private Integer displayOrder;
    private Boolean visible;
    private Boolean isExternal;
}