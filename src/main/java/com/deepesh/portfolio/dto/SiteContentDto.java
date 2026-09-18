package com.deepesh.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteContentDto {

    private ProfileDto profile;
    private SiteSettingsDto siteSettings;
    private EducationDto education;
    private SeoSettingsDto seoSettings;

    private List<FocusItemDto> focusItems = new ArrayList<>();
    private List<BuildAreaDto> buildAreas = new ArrayList<>();
    private List<SkillCategoryDto> skillCategories = new ArrayList<>();
    private List<ExplorationItemDto> explorationItems = new ArrayList<>();
    private List<OpportunityTypeDto> opportunityTypes = new ArrayList<>();
    private List<SocialLinkDto> socialLinks = new ArrayList<>();
    private List<NavigationItemDto> navigationItems = new ArrayList<>();
    private List<SectionSettingDto> sectionSettings = new ArrayList<>();
    private List<ProjectDto> projects = new ArrayList<>();
}