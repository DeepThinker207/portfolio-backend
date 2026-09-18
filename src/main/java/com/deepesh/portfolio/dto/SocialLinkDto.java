package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialLinkDto {
    private Long id;
    private String platform;
    private String label;
    private String url;
    private String iconKey;
    private Integer displayOrder;
    private Boolean visible;
}