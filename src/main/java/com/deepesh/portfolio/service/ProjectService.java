package com.deepesh.portfolio.service;

import com.deepesh.portfolio.entity.Project;
import com.deepesh.portfolio.exception.ResourceNotFoundException; // Naya import
import com.deepesh.portfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAllByOrderByIdDesc(); // Newest first
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Project not found with id: " + id
                ));
    }
    public Project updateProject(Long id, Project projectDetails) {
        // Using specific ResourceNotFoundException instead of generic RuntimeException
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));

        project.setTitle(projectDetails.getTitle());
        project.setDescription(projectDetails.getDescription());
        project.setTechStack(projectDetails.getTechStack());
        project.setGithubUrl(projectDetails.getGithubUrl());
        project.setLiveUrl(projectDetails.getLiveUrl());

        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        // Check if project exists before attempting to delete to return a proper 404
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }
}