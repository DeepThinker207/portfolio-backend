package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.SkillCategory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
    @EntityGraph(attributePaths = "skills")
    List<SkillCategory> findAllByOrderByDisplayOrderAsc();

    @EntityGraph(attributePaths = "skills")
    List<SkillCategory> findByVisibleTrueOrderByDisplayOrderAsc();
}
