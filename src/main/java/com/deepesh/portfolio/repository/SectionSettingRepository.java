package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.SectionSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SectionSettingRepository extends JpaRepository<SectionSetting, Long> {
    List<SectionSetting> findAllByOrderByDisplayOrderAsc();
    List<SectionSetting> findByVisibleTrueOrderByDisplayOrderAsc();
    Optional<SectionSetting> findBySectionKey(String sectionKey);
}
