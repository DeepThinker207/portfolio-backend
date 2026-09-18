package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.ExplorationItemDto;
import com.deepesh.portfolio.entity.ExplorationItem;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.ExplorationItemRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExplorationItemController {

    private final ExplorationItemRepository repository;

    public ExplorationItemController(ExplorationItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/exploration-items")
    public List<ExplorationItemDto> getPublicExplorationItems() {
        return SiteContentMapper.toExplorationItemDtos(
                repository.findByVisibleTrueOrderByDisplayOrderAsc());
    }

    @GetMapping("/admin/exploration-items")
    public List<ExplorationItemDto> getAllExplorationItems() {
        return SiteContentMapper.toExplorationItemDtos(
                repository.findAllByOrderByDisplayOrderAsc());
    }

    @PostMapping("/admin/exploration-items")
    public ExplorationItemDto createExplorationItem(@Valid @RequestBody ExplorationItem item) {
        item.setId(null);
        return SiteContentMapper.toExplorationItemDto(repository.save(item));
    }

    @PutMapping("/admin/exploration-items/{id}")
    public ExplorationItemDto updateExplorationItem(@PathVariable Long id, @Valid @RequestBody ExplorationItem item) {
        ExplorationItem existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exploration item not found with id: " + id));
        existing.setName(item.getName());
        existing.setDisplayOrder(item.getDisplayOrder());
        existing.setVisible(item.getVisible());
        return SiteContentMapper.toExplorationItemDto(repository.save(existing));
    }

    @DeleteMapping("/admin/exploration-items/{id}")
    public ResponseEntity<?> deleteExplorationItem(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Exploration item not found with id: " + id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
