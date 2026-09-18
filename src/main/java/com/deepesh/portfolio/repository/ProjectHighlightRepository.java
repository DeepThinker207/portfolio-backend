package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.ProjectHighlight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectHighlightRepository extends JpaRepository<ProjectHighlight, Long> {
    List<ProjectHighlight> findByProjectIdOrderByDisplayOrderAsc(Long projectId);
    List<ProjectHighlight> findByProjectIdAndVisibleTrueOrderByDisplayOrderAsc(Long projectId);
    void deleteByProjectId(Long projectId);
}
