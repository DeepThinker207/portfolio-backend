package com.deepesh.portfolio.service;

import com.deepesh.portfolio.entity.Project;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project) {
        if (Boolean.TRUE.equals(project.getFeatured())) {
            projectRepository.clearAllFeatured();
        }
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAllByOrderByDisplayOrderAscIdDesc();
    }

    public List<Project> getVisibleProjects() {
        return projectRepository.findByVisibleTrueOrderByDisplayOrderAscIdDesc();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findWithHighlightsById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Project not found with id: " + id
                ));
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));

        project.setTitle(projectDetails.getTitle());
        project.setDescription(projectDetails.getDescription());
        project.setTechStack(projectDetails.getTechStack());
        project.setGithubUrl(projectDetails.getGithubUrl());
        project.setLiveUrl(projectDetails.getLiveUrl());
        project.setVisible(projectDetails.getVisible());
        project.setDisplayOrder(projectDetails.getDisplayOrder());
        project.setImageUrl(projectDetails.getImageUrl());

        // Featured uniqueness enforcement
        if (Boolean.TRUE.equals(projectDetails.getFeatured()) && !Boolean.TRUE.equals(project.getFeatured())) {
            projectRepository.clearFeaturedExcept(id);
            project.setFeatured(true);
        } else if (Boolean.FALSE.equals(projectDetails.getFeatured())) {
            project.setFeatured(false);
        }

        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }
}
