package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.entity.Profile;
import com.deepesh.portfolio.repository.ProfileRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @GetMapping
    public Profile getProfile() {
        return profileRepository.findById(1L).orElse(new Profile());
    }

    // Only admin can update profile
    @PutMapping
    public Profile updateProfile(@RequestBody Profile updatedProfile) {
        updatedProfile.setId(1L); // Forcefully ID 1 set
        return profileRepository.save(updatedProfile);
    }
}