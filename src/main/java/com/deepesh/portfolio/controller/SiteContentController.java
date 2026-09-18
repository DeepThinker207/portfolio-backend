package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.SiteContentDto;
import com.deepesh.portfolio.service.SiteContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SiteContentController {

    private final SiteContentService siteContentService;

    public SiteContentController(SiteContentService siteContentService) {
        this.siteContentService = siteContentService;
    }

    @GetMapping("/site")
    public SiteContentDto getSiteContent() {
        return siteContentService.getPublicSiteContent();
    }
}