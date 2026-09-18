package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.OpportunityTypeDto;
import com.deepesh.portfolio.entity.OpportunityType;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.OpportunityTypeRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OpportunityTypeController {

    private final OpportunityTypeRepository repository;

    public OpportunityTypeController(OpportunityTypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/opportunity-types")
    public List<OpportunityTypeDto> getPublicOpportunityTypes() {
        return SiteContentMapper.toOpportunityTypeDtos(
                repository.findByVisibleTrueOrderByDisplayOrderAsc());
    }

    @GetMapping("/admin/opportunity-types")
    public List<OpportunityTypeDto> getAllOpportunityTypes() {
        return SiteContentMapper.toOpportunityTypeDtos(
                repository.findAllByOrderByDisplayOrderAsc());
    }

    @PostMapping("/admin/opportunity-types")
    public OpportunityTypeDto createOpportunityType(@Valid @RequestBody OpportunityType type) {
        type.setId(null);
        return SiteContentMapper.toOpportunityTypeDto(repository.save(type));
    }

    @PutMapping("/admin/opportunity-types/{id}")
    public OpportunityTypeDto updateOpportunityType(@PathVariable Long id, @Valid @RequestBody OpportunityType type) {
        OpportunityType existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Opportunity type not found with id: " + id));
        existing.setLabel(type.getLabel());
        existing.setDisplayOrder(type.getDisplayOrder());
        existing.setVisible(type.getVisible());
        return SiteContentMapper.toOpportunityTypeDto(repository.save(existing));
    }

    @DeleteMapping("/admin/opportunity-types/{id}")
    public ResponseEntity<?> deleteOpportunityType(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Opportunity type not found with id: " + id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
