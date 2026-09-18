package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.SocialLinkDto;
import com.deepesh.portfolio.entity.SocialLink;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.SocialLinkRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SocialLinkController {

    private final SocialLinkRepository repository;

    public SocialLinkController(SocialLinkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/social-links")
    public List<SocialLinkDto> getPublicSocialLinks() {
        return SiteContentMapper.toSocialLinkDtos(
                repository.findByVisibleTrueOrderByDisplayOrderAsc());
    }

    @GetMapping("/admin/social-links")
    public List<SocialLinkDto> getAllSocialLinks() {
        return SiteContentMapper.toSocialLinkDtos(
                repository.findAllByOrderByDisplayOrderAsc());
    }

    @PostMapping("/admin/social-links")
    public SocialLinkDto createSocialLink(@Valid @RequestBody SocialLink link) {
        link.setId(null);
        return SiteContentMapper.toSocialLinkDto(repository.save(link));
    }

    @PutMapping("/admin/social-links/{id}")
    public SocialLinkDto updateSocialLink(@PathVariable Long id, @Valid @RequestBody SocialLink link) {
        SocialLink existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Social link not found with id: " + id));
        existing.setPlatform(link.getPlatform());
        existing.setLabel(link.getLabel());
        existing.setUrl(link.getUrl());
        existing.setIconKey(link.getIconKey());
        existing.setDisplayOrder(link.getDisplayOrder());
        existing.setVisible(link.getVisible());
        return SiteContentMapper.toSocialLinkDto(repository.save(existing));
    }

    @DeleteMapping("/admin/social-links/{id}")
    public ResponseEntity<?> deleteSocialLink(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Social link not found with id: " + id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
