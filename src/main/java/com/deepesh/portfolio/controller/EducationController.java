package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.EducationDto;
import com.deepesh.portfolio.entity.Education;
import com.deepesh.portfolio.repository.EducationRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EducationController {

    private final EducationRepository repository;

    public EducationController(EducationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/education")
    public EducationDto getEducation() {
        return SiteContentMapper.toEducationDto(
                repository.findById(1L).orElse(null));
    }

    @PutMapping("/admin/education")
    public EducationDto updateEducation(@RequestBody Education education) {
        education.setId(1L);
        return SiteContentMapper.toEducationDto(repository.save(education));
    }
}
