package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.SeoSettingsDto;
import com.deepesh.portfolio.entity.SeoSettings;
import com.deepesh.portfolio.repository.SeoSettingsRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SeoSettingsController {

    private final SeoSettingsRepository repository;

    public SeoSettingsController(SeoSettingsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/seo-settings")
    public SeoSettingsDto getSeoSettings() {
        return SiteContentMapper.toSeoSettingsDto(
                repository.findById(1L).orElse(null));
    }

    @PutMapping("/admin/seo-settings")
    public SeoSettingsDto updateSeoSettings(@RequestBody SeoSettings settings) {
        settings.setId(1L);
        return SiteContentMapper.toSeoSettingsDto(repository.save(settings));
    }
}
