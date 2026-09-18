package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.BuildArea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BuildAreaRepository extends JpaRepository<BuildArea, Long> {
    List<BuildArea> findAllByOrderByDisplayOrderAsc();
    List<BuildArea> findByVisibleTrueOrderByDisplayOrderAsc();
}
