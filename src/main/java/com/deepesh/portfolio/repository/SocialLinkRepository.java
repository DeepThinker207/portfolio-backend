package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SocialLinkRepository extends JpaRepository<SocialLink, Long> {
    List<SocialLink> findAllByOrderByDisplayOrderAsc();
    List<SocialLink> findByVisibleTrueOrderByDisplayOrderAsc();
}
