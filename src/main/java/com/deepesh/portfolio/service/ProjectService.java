package com.deepesh.portfolio.service;

import com.deepesh.portfolio.entity.Project;
import com.deepesh.portfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    // Constructor Injection (Best Practice)
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project) {
        return projectRepository.save(project); // Save to database
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll(); // Fetch from database
    }
}