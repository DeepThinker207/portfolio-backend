package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.ProjectDto;
import com.deepesh.portfolio.service.ProjectService;
import com.deepesh.portfolio.service.SiteContentMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/projects")
public class AdminProjectController {

    private final ProjectService projectService;

    public AdminProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return SiteContentMapper.toProjectDtos(projectService.getAllProjects(), false);
    }
}