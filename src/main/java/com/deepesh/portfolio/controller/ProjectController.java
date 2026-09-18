package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.ProjectDto;
import com.deepesh.portfolio.entity.Project;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.service.ProjectService;
import com.deepesh.portfolio.service.SiteContentMapper;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ProjectDto createProject(@Valid @RequestBody Project project) {
        return SiteContentMapper.toProjectDto(projectService.addProject(project), false);
    }

    @GetMapping
    public List<ProjectDto> getPublicProjects() {
        return SiteContentMapper.toProjectDtos(projectService.getVisibleProjects(), true);
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        if (project.getVisible() != null && !project.getVisible()) {
            throw new ResourceNotFoundException("Project not found with id: " + id);
        }
        return SiteContentMapper.toProjectDto(project, true);
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable Long id, @Valid @RequestBody Project project) {
        return SiteContentMapper.toProjectDto(projectService.updateProject(id, project), false);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}