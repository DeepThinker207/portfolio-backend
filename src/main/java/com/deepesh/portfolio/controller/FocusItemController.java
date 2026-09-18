package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.FocusItemDto;
import com.deepesh.portfolio.entity.FocusItem;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.FocusItemRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FocusItemController {

    private final FocusItemRepository repository;

    public FocusItemController(FocusItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/focus-items")
    public List<FocusItemDto> getPublicFocusItems() {
        return SiteContentMapper.toFocusItemDtos(
                repository.findByVisibleTrueOrderByDisplayOrderAsc());
    }

    @GetMapping("/admin/focus-items")
    public List<FocusItemDto> getAllFocusItems() {
        return SiteContentMapper.toFocusItemDtos(
                repository.findAllByOrderByDisplayOrderAsc());
    }

    @PostMapping("/admin/focus-items")
    public FocusItemDto createFocusItem(@Valid @RequestBody FocusItem item) {
        item.setId(null);
        return SiteContentMapper.toFocusItemDto(repository.save(item));
    }

    @PutMapping("/admin/focus-items/{id}")
    public FocusItemDto updateFocusItem(@PathVariable Long id, @Valid @RequestBody FocusItem item) {
        FocusItem existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Focus item not found with id: " + id));
        existing.setLabel(item.getLabel());
        existing.setDisplayOrder(item.getDisplayOrder());
        existing.setVisible(item.getVisible());
        return SiteContentMapper.toFocusItemDto(repository.save(existing));
    }

    @DeleteMapping("/admin/focus-items/{id}")
    public ResponseEntity<?> deleteFocusItem(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Focus item not found with id: " + id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
