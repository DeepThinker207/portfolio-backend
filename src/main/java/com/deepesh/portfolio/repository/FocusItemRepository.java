package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.FocusItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FocusItemRepository extends JpaRepository<FocusItem, Long> {
    List<FocusItem> findAllByOrderByDisplayOrderAsc();
    List<FocusItem> findByVisibleTrueOrderByDisplayOrderAsc();
}
