package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByCategoryIdOrderByDisplayOrderAsc(Long categoryId);
    List<Skill> findByCategoryIdAndVisibleTrueOrderByDisplayOrderAsc(Long categoryId);
    void deleteByCategoryId(Long categoryId);
}
