package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.SkillCategoryDto;
import com.deepesh.portfolio.dto.SkillDto;
import com.deepesh.portfolio.entity.Skill;
import com.deepesh.portfolio.entity.SkillCategory;
import com.deepesh.portfolio.exception.ResourceNotFoundException;
import com.deepesh.portfolio.repository.SkillCategoryRepository;
import com.deepesh.portfolio.repository.SkillRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkillController {

    private final SkillCategoryRepository categoryRepository;
    private final SkillRepository skillRepository;

    public SkillController(SkillCategoryRepository categoryRepository, SkillRepository skillRepository) {
        this.categoryRepository = categoryRepository;
        this.skillRepository = skillRepository;
    }

    @GetMapping("/skill-categories")
    public List<SkillCategoryDto> getPublicSkillCategories() {
        return SiteContentMapper.toSkillCategoryDtos(
                categoryRepository.findByVisibleTrueOrderByDisplayOrderAsc(), true);
    }

    @GetMapping("/admin/skill-categories")
    public List<SkillCategoryDto> getAllSkillCategories() {
        return SiteContentMapper.toSkillCategoryDtos(
                categoryRepository.findAllByOrderByDisplayOrderAsc(), false);
    }

    @PostMapping("/admin/skill-categories")
    public SkillCategoryDto createCategory(@Valid @RequestBody SkillCategory category) {
        category.setId(null);
        category.getSkills().clear();
        return SiteContentMapper.toSkillCategoryDto(categoryRepository.save(category), false);
    }

    @PutMapping("/admin/skill-categories/{id}")
    public SkillCategoryDto updateCategory(@PathVariable Long id, @Valid @RequestBody SkillCategory category) {
        SkillCategory existing = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill category not found with id: " + id));
        existing.setName(category.getName());
        existing.setIconKey(category.getIconKey());
        existing.setAccent(category.getAccent());
        existing.setDisplayOrder(category.getDisplayOrder());
        existing.setVisible(category.getVisible());
        return SiteContentMapper.toSkillCategoryDto(categoryRepository.save(existing), false);
    }

    @DeleteMapping("/admin/skill-categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Skill category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Skills within a category
    @GetMapping("/admin/skill-categories/{categoryId}/skills")
    public List<SkillDto> getSkillsForCategory(@PathVariable Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Skill category not found with id: " + categoryId);
        }
        return SiteContentMapper.toSkillDtos(
                skillRepository.findByCategoryIdOrderByDisplayOrderAsc(categoryId));
    }

    @PostMapping("/admin/skill-categories/{categoryId}/skills")
    public SkillDto createSkill(@PathVariable Long categoryId, @Valid @RequestBody Skill skill) {
        SkillCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill category not found with id: " + categoryId));
        skill.setId(null);
        skill.setCategory(category);
        return SiteContentMapper.toSkillDto(skillRepository.save(skill));
    }

    @PutMapping("/admin/skills/{id}")
    public SkillDto updateSkill(@PathVariable Long id, @Valid @RequestBody Skill skill) {
        Skill existing = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + id));
        existing.setName(skill.getName());
        existing.setDisplayOrder(skill.getDisplayOrder());
        existing.setVisible(skill.getVisible());
        return SiteContentMapper.toSkillDto(skillRepository.save(existing));
    }

    @DeleteMapping("/admin/skills/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long id) {
        if (!skillRepository.existsById(id)) {
            throw new ResourceNotFoundException("Skill not found with id: " + id);
        }
        skillRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}