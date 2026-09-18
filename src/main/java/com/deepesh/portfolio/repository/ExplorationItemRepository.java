package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.ExplorationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExplorationItemRepository extends JpaRepository<ExplorationItem, Long> {
    List<ExplorationItem> findAllByOrderByDisplayOrderAsc();
    List<ExplorationItem> findByVisibleTrueOrderByDisplayOrderAsc();
}
