package com.deepesh.portfolio.service;

import com.deepesh.portfolio.dto.*;
import com.deepesh.portfolio.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maps JPA entities to public response DTOs.
 *
 * <p>The DTO boundary prevents Jackson from walking bidirectional JPA
 * relationships (SkillCategory &lt;-&gt; Skill, Project &lt;-&gt; ProjectHighlight),
 * which would otherwise produce circular JSON or lazy-load errors.</p>
 */
public final class SiteContentMapper {

    private SiteContentMapper() {
    }

    public static ProfileDto toProfileDto(Profile entity) {
        if (entity == null) return null;
        return new ProfileDto(
                entity.getId(),
                entity.getName(),
                entity.getBio(),
                entity.getEmail(),
                entity.getLocation(),
                entity.getGithubUrl(),
                entity.getLinkedinUrl(),
                entity.getResumeUrl(),
                entity.getRoleTitle(),
                entity.getAvailabilityEnabled(),
                entity.getAvailabilityLabel());
    }

    public static EducationDto toEducationDto(Education entity) {
        if (entity == null) return null;
        return new EducationDto(
                entity.getId(),
                entity.getDegree(),
                entity.getFieldOfStudy(),
                entity.getInstitution(),
                entity.getGraduationDate(),
                entity.getGraduationShort(),
                entity.getLocation(),
                entity.getDisplayOrder(),
                entity.getVisible());
    }

    public static SiteSettingsDto toSiteSettingsDto(SiteSettings entity) {
        if (entity == null) return null;
        return new SiteSettingsDto(
                entity.getId(),
                entity.getHeroEyebrow(),
                entity.getHeroHeading(),
                entity.getHeroSupportingText(),
                entity.getHeroPrimaryCtaLabel(),
                entity.getHeroPrimaryCtaTarget(),
                entity.getHeroSecondaryCtaLabel(),
                entity.getHeroSecondaryCtaTarget(),
                entity.getHeroVisible(),
                entity.getContactHeading(),
                entity.getContactHeadline(),
                entity.getContactVisible(),
                entity.getFooterText(),
                entity.getSiteName());
    }

    public static SeoSettingsDto toSeoSettingsDto(SeoSettings entity) {
        if (entity == null) return null;
        return new SeoSettingsDto(
                entity.getId(),
                entity.getPageTitle(),
                entity.getMetaDescription(),
                entity.getOgTitle(),
                entity.getOgDescription(),
                entity.getOgImageUrl(),
                entity.getTwitterTitle(),
                entity.getTwitterDescription(),
                entity.getRobots());
    }

    public static FocusItemDto toFocusItemDto(FocusItem entity) {
        if (entity == null) return null;
        return new FocusItemDto(entity.getId(), entity.getLabel(), entity.getDisplayOrder(), entity.getVisible());
    }

    public static List<FocusItemDto> toFocusItemDtos(List<FocusItem> entities) {
        if (entities == null) return Collections.emptyList();
        List<FocusItemDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toFocusItemDto(e)));
        return dtos;
    }

    public static BuildAreaDto toBuildAreaDto(BuildArea entity) {
        if (entity == null) return null;
        return new BuildAreaDto(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getIconKey(), entity.getDisplayOrder(), entity.getVisible());
    }

    public static List<BuildAreaDto> toBuildAreaDtos(List<BuildArea> entities) {
        if (entities == null) return Collections.emptyList();
        List<BuildAreaDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toBuildAreaDto(e)));
        return dtos;
    }

    public static SkillDto toSkillDto(Skill entity) {
        if (entity == null) return null;
        return new SkillDto(entity.getId(), entity.getName(), entity.getDisplayOrder(), entity.getVisible());
    }

    public static List<SkillDto> toSkillDtos(List<Skill> entities) {
        if (entities == null) return Collections.emptyList();
        List<SkillDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toSkillDto(e)));
        return dtos;
    }

    public static SkillCategoryDto toSkillCategoryDto(SkillCategory entity, boolean publicOnly) {
        if (entity == null) return null;
        List<Skill> skills = entity.getSkills();
        if (publicOnly && skills != null) {
            skills = skills.stream().filter(s -> s.getVisible() != null && s.getVisible()).toList();
        }
        return new SkillCategoryDto(
                entity.getId(),
                entity.getName(),
                entity.getIconKey(),
                entity.getAccent(),
                entity.getDisplayOrder(),
                entity.getVisible(),
                skills == null ? new ArrayList<>() : toSkillDtos(skills));
    }

    public static List<SkillCategoryDto> toSkillCategoryDtos(List<SkillCategory> entities, boolean publicOnly) {
        if (entities == null) return Collections.emptyList();
        List<SkillCategoryDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toSkillCategoryDto(e, publicOnly)));
        return dtos;
    }

    public static ExplorationItemDto toExplorationItemDto(ExplorationItem entity) {
        if (entity == null) return null;
        return new ExplorationItemDto(entity.getId(), entity.getName(), entity.getDisplayOrder(), entity.getVisible());
    }

    public static List<ExplorationItemDto> toExplorationItemDtos(List<ExplorationItem> entities) {
        if (entities == null) return Collections.emptyList();
        List<ExplorationItemDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toExplorationItemDto(e)));
        return dtos;
    }

    public static OpportunityTypeDto toOpportunityTypeDto(OpportunityType entity) {
        if (entity == null) return null;
        return new OpportunityTypeDto(entity.getId(), entity.getLabel(), entity.getDisplayOrder(), entity.getVisible());
    }

    public static List<OpportunityTypeDto> toOpportunityTypeDtos(List<OpportunityType> entities) {
        if (entities == null) return Collections.emptyList();
        List<OpportunityTypeDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toOpportunityTypeDto(e)));
        return dtos;
    }

    public static SocialLinkDto toSocialLinkDto(SocialLink entity) {
        if (entity == null) return null;
        return new SocialLinkDto(entity.getId(), entity.getPlatform(), entity.getLabel(), entity.getUrl(), entity.getIconKey(), entity.getDisplayOrder(), entity.getVisible());
    }

    public static List<SocialLinkDto> toSocialLinkDtos(List<SocialLink> entities) {
        if (entities == null) return Collections.emptyList();
        List<SocialLinkDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toSocialLinkDto(e)));
        return dtos;
    }

    public static NavigationItemDto toNavigationItemDto(NavigationItem entity) {
        if (entity == null) return null;
        return new NavigationItemDto(entity.getId(), entity.getLabel(), entity.getHref(), entity.getDisplayOrder(), entity.getVisible(), entity.getIsExternal());
    }

    public static List<NavigationItemDto> toNavigationItemDtos(List<NavigationItem> entities) {
        if (entities == null) return Collections.emptyList();
        List<NavigationItemDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toNavigationItemDto(e)));
        return dtos;
    }

    public static SectionSettingDto toSectionSettingDto(SectionSetting entity) {
        if (entity == null) return null;
        return new SectionSettingDto(entity.getId(), entity.getSectionKey(), entity.getLabel(), entity.getDisplayOrder(), entity.getVisible());
    }

    public static List<SectionSettingDto> toSectionSettingDtos(List<SectionSetting> entities) {
        if (entities == null) return Collections.emptyList();
        List<SectionSettingDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toSectionSettingDto(e)));
        return dtos;
    }

    public static HighlightDto toHighlightDto(ProjectHighlight entity) {
        if (entity == null) return null;
        return new HighlightDto(entity.getId(), entity.getText(), entity.getDisplayOrder(), entity.getVisible());
    }

    public static List<HighlightDto> toHighlightDtos(List<ProjectHighlight> entities, boolean publicOnly) {
        if (entities == null) return Collections.emptyList();
        List<HighlightDto> dtos = new ArrayList<>();
        for (ProjectHighlight h : entities) {
            if (publicOnly && h.getVisible() != null && !h.getVisible()) continue;
            dtos.add(toHighlightDto(h));
        }
        return dtos;
    }

    public static ProjectDto toProjectDto(Project entity, boolean publicOnly) {
        if (entity == null) return null;
        return new ProjectDto(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getTechStack(),
                entity.getGithubUrl(),
                entity.getLiveUrl(),
                entity.getVisible(),
                entity.getFeatured(),
                entity.getDisplayOrder(),
                entity.getImageUrl(),
                toHighlightDtos(entity.getHighlights(), publicOnly));
    }

    public static List<ProjectDto> toProjectDtos(List<Project> entities, boolean publicOnly) {
        if (entities == null) return Collections.emptyList();
        List<ProjectDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(toProjectDto(e, publicOnly)));
        return dtos;
    }
}