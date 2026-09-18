package com.deepesh.portfolio.service;

import com.deepesh.portfolio.dto.*;
import com.deepesh.portfolio.repository.*;
import com.deepesh.portfolio.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SiteContentService {

    private final ProfileRepository profileRepository;
    private final SiteSettingsRepository siteSettingsRepository;
    private final EducationRepository educationRepository;
    private final FocusItemRepository focusItemRepository;
    private final BuildAreaRepository buildAreaRepository;
    private final SkillCategoryRepository skillCategoryRepository;
    private final ExplorationItemRepository explorationItemRepository;
    private final OpportunityTypeRepository opportunityTypeRepository;
    private final SocialLinkRepository socialLinkRepository;
    private final NavigationItemRepository navigationItemRepository;
    private final SectionSettingRepository sectionSettingRepository;
    private final SeoSettingsRepository seoSettingsRepository;
    private final ProjectRepository projectRepository;

    public SiteContentService(
            ProfileRepository profileRepository,
            SiteSettingsRepository siteSettingsRepository,
            EducationRepository educationRepository,
            FocusItemRepository focusItemRepository,
            BuildAreaRepository buildAreaRepository,
            SkillCategoryRepository skillCategoryRepository,
            ExplorationItemRepository explorationItemRepository,
            OpportunityTypeRepository opportunityTypeRepository,
            SocialLinkRepository socialLinkRepository,
            NavigationItemRepository navigationItemRepository,
            SectionSettingRepository sectionSettingRepository,
            SeoSettingsRepository seoSettingsRepository,
            ProjectRepository projectRepository) {
        this.profileRepository = profileRepository;
        this.siteSettingsRepository = siteSettingsRepository;
        this.educationRepository = educationRepository;
        this.focusItemRepository = focusItemRepository;
        this.buildAreaRepository = buildAreaRepository;
        this.skillCategoryRepository = skillCategoryRepository;
        this.explorationItemRepository = explorationItemRepository;
        this.opportunityTypeRepository = opportunityTypeRepository;
        this.socialLinkRepository = socialLinkRepository;
        this.navigationItemRepository = navigationItemRepository;
        this.sectionSettingRepository = sectionSettingRepository;
        this.seoSettingsRepository = seoSettingsRepository;
        this.projectRepository = projectRepository;
    }

    public SiteContentDto getPublicSiteContent() {
        SiteContentDto dto = new SiteContentDto();

        dto.setProfile(SiteContentMapper.toProfileDto(
                profileRepository.findById(1L).orElse(null)));
        dto.setSiteSettings(SiteContentMapper.toSiteSettingsDto(
                siteSettingsRepository.findById(1L).orElse(null)));
        dto.setEducation(SiteContentMapper.toEducationDto(
                educationRepository.findById(1L).orElse(null)));
        dto.setSeoSettings(SiteContentMapper.toSeoSettingsDto(
                seoSettingsRepository.findById(1L).orElse(null)));

        dto.setFocusItems(SiteContentMapper.toFocusItemDtos(
                focusItemRepository.findByVisibleTrueOrderByDisplayOrderAsc()));
        dto.setBuildAreas(SiteContentMapper.toBuildAreaDtos(
                buildAreaRepository.findByVisibleTrueOrderByDisplayOrderAsc()));
        dto.setSkillCategories(SiteContentMapper.toSkillCategoryDtos(
                skillCategoryRepository.findByVisibleTrueOrderByDisplayOrderAsc(), true));
        dto.setExplorationItems(SiteContentMapper.toExplorationItemDtos(
                explorationItemRepository.findByVisibleTrueOrderByDisplayOrderAsc()));
        dto.setOpportunityTypes(SiteContentMapper.toOpportunityTypeDtos(
                opportunityTypeRepository.findByVisibleTrueOrderByDisplayOrderAsc()));
        dto.setSocialLinks(SiteContentMapper.toSocialLinkDtos(
                socialLinkRepository.findByVisibleTrueOrderByDisplayOrderAsc()));
        dto.setNavigationItems(SiteContentMapper.toNavigationItemDtos(
                navigationItemRepository.findByVisibleTrueOrderByDisplayOrderAsc()));
        dto.setSectionSettings(SiteContentMapper.toSectionSettingDtos(
                sectionSettingRepository.findByVisibleTrueOrderByDisplayOrderAsc()));
        dto.setProjects(SiteContentMapper.toProjectDtos(
                projectRepository.findByVisibleTrueOrderByDisplayOrderAscIdDesc(), true));

        return dto;
    }
}