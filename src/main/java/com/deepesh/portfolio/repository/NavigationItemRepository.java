package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.NavigationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NavigationItemRepository extends JpaRepository<NavigationItem, Long> {
    List<NavigationItem> findAllByOrderByDisplayOrderAsc();
    List<NavigationItem> findByVisibleTrueOrderByDisplayOrderAsc();
}
