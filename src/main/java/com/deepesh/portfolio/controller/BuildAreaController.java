package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.BuildAreaDto;
import com.deepesh.portfolio.entity.BuildArea;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.BuildAreaRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BuildAreaController {

    private final BuildAreaRepository repository;

    public BuildAreaController(BuildAreaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/build-areas")
    public List<BuildAreaDto> getPublicBuildAreas() {
        return SiteContentMapper.toBuildAreaDtos(
                repository.findByVisibleTrueOrderByDisplayOrderAsc());
    }

    @GetMapping("/admin/build-areas")
    public List<BuildAreaDto> getAllBuildAreas() {
        return SiteContentMapper.toBuildAreaDtos(
                repository.findAllByOrderByDisplayOrderAsc());
    }

    @PostMapping("/admin/build-areas")
    public BuildAreaDto createBuildArea(@Valid @RequestBody BuildArea area) {
        area.setId(null);
        return SiteContentMapper.toBuildAreaDto(repository.save(area));
    }

    @PutMapping("/admin/build-areas/{id}")
    public BuildAreaDto updateBuildArea(@PathVariable Long id, @Valid @RequestBody BuildArea area) {
        BuildArea existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Build area not found with id: " + id));
        existing.setTitle(area.getTitle());
        existing.setDescription(area.getDescription());
        existing.setIconKey(area.getIconKey());
        existing.setDisplayOrder(area.getDisplayOrder());
        existing.setVisible(area.getVisible());
        return SiteContentMapper.toBuildAreaDto(repository.save(existing));
    }

    @DeleteMapping("/admin/build-areas/{id}")
    public ResponseEntity<?> deleteBuildArea(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Build area not found with id: " + id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
