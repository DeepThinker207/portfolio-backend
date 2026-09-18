package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.SiteSettingsDto;
import com.deepesh.portfolio.entity.SiteSettings;
import com.deepesh.portfolio.repository.SiteSettingsRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SiteSettingsController {

    private final SiteSettingsRepository repository;

    public SiteSettingsController(SiteSettingsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/site-settings")
    public SiteSettingsDto getSiteSettings() {
        return SiteContentMapper.toSiteSettingsDto(
                repository.findById(1L).orElse(null));
    }

    @PutMapping("/admin/site-settings")
    public SiteSettingsDto updateSiteSettings(@RequestBody SiteSettings settings) {
        settings.setId(1L);
        return SiteContentMapper.toSiteSettingsDto(repository.save(settings));
    }
}
