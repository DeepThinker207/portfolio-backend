package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.entity.Project;
import com.deepesh.portfolio.service.ProjectService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*") // This will allow React to call API without CORS error
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // POST Request: to add new projects
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    // GET Request: to see all the projects
    @GetMapping
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }
}