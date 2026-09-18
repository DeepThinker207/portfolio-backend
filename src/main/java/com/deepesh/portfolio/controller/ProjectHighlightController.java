package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.HighlightDto;
import com.deepesh.portfolio.entity.ProjectHighlight;
import com.deepesh.portfolio.entity.Project;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.ProjectHighlightRepository;
import com.deepesh.portfolio.repository.ProjectRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectHighlightController {

    private final ProjectHighlightRepository highlightRepository;
    private final ProjectRepository projectRepository;

    public ProjectHighlightController(ProjectHighlightRepository highlightRepository, ProjectRepository projectRepository) {
        this.highlightRepository = highlightRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects/{projectId}/highlights")
    public List<HighlightDto> getPublicHighlights(@PathVariable Long projectId) {
        return SiteContentMapper.toHighlightDtos(
                highlightRepository.findByProjectIdAndVisibleTrueOrderByDisplayOrderAsc(projectId), true);
    }

    @GetMapping("/admin/projects/{projectId}/highlights")
    public List<HighlightDto> getAllHighlights(@PathVariable Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ResourceNotFoundException("Project not found with id: " + projectId);
        }
        return SiteContentMapper.toHighlightDtos(
                highlightRepository.findByProjectIdOrderByDisplayOrderAsc(projectId), false);
    }

    @PostMapping("/admin/projects/{projectId}/highlights")
    public HighlightDto createHighlight(@PathVariable Long projectId, @Valid @RequestBody ProjectHighlight highlight) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + projectId));
        highlight.setId(null);
        highlight.setProject(project);
        return SiteContentMapper.toHighlightDto(highlightRepository.save(highlight));
    }

    @PutMapping("/admin/highlights/{id}")
    public HighlightDto updateHighlight(@PathVariable Long id, @Valid @RequestBody ProjectHighlight highlight) {
        ProjectHighlight existing = highlightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Highlight not found with id: " + id));
        existing.setText(highlight.getText());
        existing.setDisplayOrder(highlight.getDisplayOrder());
        existing.setVisible(highlight.getVisible());
        return SiteContentMapper.toHighlightDto(highlightRepository.save(existing));
    }

    @DeleteMapping("/admin/highlights/{id}")
    public ResponseEntity<?> deleteHighlight(@PathVariable Long id) {
        if (!highlightRepository.existsById(id)) {
            throw new ResourceNotFoundException("Highlight not found with id: " + id);
        }
        highlightRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}