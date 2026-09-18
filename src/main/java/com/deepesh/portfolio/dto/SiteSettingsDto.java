package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteSettingsDto {
    private Long id;
    private String heroEyebrow;
    private String heroHeading;
    private String heroSupportingText;
    private String heroPrimaryCtaLabel;
    private String heroPrimaryCtaTarget;
    private String heroSecondaryCtaLabel;
    private String heroSecondaryCtaTarget;
    private Boolean heroVisible;
    private String contactHeading;
    private String contactHeadline;
    private Boolean contactVisible;
    private String footerText;
    private String siteName;
}