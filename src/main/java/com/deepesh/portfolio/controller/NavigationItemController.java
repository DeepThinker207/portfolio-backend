package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.NavigationItemDto;
import com.deepesh.portfolio.entity.NavigationItem;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.NavigationItemRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NavigationItemController {

    private final NavigationItemRepository repository;

    public NavigationItemController(NavigationItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/navigation-items")
    public List<NavigationItemDto> getPublicNavigationItems() {
        return SiteContentMapper.toNavigationItemDtos(
                repository.findByVisibleTrueOrderByDisplayOrderAsc());
    }

    @GetMapping("/admin/navigation-items")
    public List<NavigationItemDto> getAllNavigationItems() {
        return SiteContentMapper.toNavigationItemDtos(
                repository.findAllByOrderByDisplayOrderAsc());
    }

    @PostMapping("/admin/navigation-items")
    public NavigationItemDto createNavigationItem(@Valid @RequestBody NavigationItem item) {
        item.setId(null);
        return SiteContentMapper.toNavigationItemDto(repository.save(item));
    }

    @PutMapping("/admin/navigation-items/{id}")
    public NavigationItemDto updateNavigationItem(@PathVariable Long id, @Valid @RequestBody NavigationItem item) {
        NavigationItem existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Navigation item not found with id: " + id));
        existing.setLabel(item.getLabel());
        existing.setHref(item.getHref());
        existing.setDisplayOrder(item.getDisplayOrder());
        existing.setVisible(item.getVisible());
        existing.setIsExternal(item.getIsExternal());
        return SiteContentMapper.toNavigationItemDto(repository.save(existing));
    }

    @DeleteMapping("/admin/navigation-items/{id}")
    public ResponseEntity<?> deleteNavigationItem(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Navigation item not found with id: " + id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
