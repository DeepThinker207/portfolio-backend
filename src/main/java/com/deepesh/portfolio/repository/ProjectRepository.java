package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @EntityGraph(attributePaths = "highlights")
    List<Project> findAllByOrderByDisplayOrderAscIdDesc();

    @EntityGraph(attributePaths = "highlights")
    List<Project> findByVisibleTrueOrderByDisplayOrderAscIdDesc();

    @EntityGraph(attributePaths = "highlights")
    Optional<Project> findWithHighlightsById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Project p SET p.featured = false WHERE p.featured = true AND p.id <> :id")
    void clearFeaturedExcept(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Project p SET p.featured = false WHERE p.featured = true")
    void clearAllFeatured();
}
