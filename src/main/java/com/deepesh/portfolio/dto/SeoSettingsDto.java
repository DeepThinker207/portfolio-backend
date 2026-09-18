package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeoSettingsDto {
    private Long id;
    private String pageTitle;
    private String metaDescription;
    private String ogTitle;
    private String ogDescription;
    private String ogImageUrl;
    private String twitterTitle;
    private String twitterDescription;
    private String robots;
}