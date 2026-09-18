package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.ProfileDto;
import com.deepesh.portfolio.entity.Profile;
import com.deepesh.portfolio.repository.ProfileRepository;
import com.deepesh.portfolio.service.SiteContentMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping
    public ProfileDto getProfile() {
        return SiteContentMapper.toProfileDto(
                profileRepository.findById(1L).orElse(null));
    }

    @PutMapping
    public ProfileDto updateProfile(@RequestBody Profile updatedProfile) {
        updatedProfile.setId(1L);
        return SiteContentMapper.toProfileDto(
                profileRepository.save(updatedProfile));
    }
}
