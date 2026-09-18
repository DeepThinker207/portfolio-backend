package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.SectionSettingDto;
import com.deepesh.portfolio.entity.SectionSetting;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.SectionSettingRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SectionSettingController {

    private final SectionSettingRepository repository;

    public SectionSettingController(SectionSettingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/section-settings")
    public List<SectionSettingDto> getPublicSectionSettings() {
        return SiteContentMapper.toSectionSettingDtos(
                repository.findByVisibleTrueOrderByDisplayOrderAsc());
    }

    @GetMapping("/admin/section-settings")
    public List<SectionSettingDto> getAllSectionSettings() {
        return SiteContentMapper.toSectionSettingDtos(
                repository.findAllByOrderByDisplayOrderAsc());
    }

    @PutMapping("/admin/section-settings/{id}")
    public SectionSettingDto updateSectionSetting(@PathVariable Long id, @Valid @RequestBody SectionSetting section) {
        SectionSetting existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Section setting not found with id: " + id));
        existing.setLabel(section.getLabel());
        existing.setDisplayOrder(section.getDisplayOrder());
        existing.setVisible(section.getVisible());
        return SiteContentMapper.toSectionSettingDto(repository.save(existing));
    }
}
