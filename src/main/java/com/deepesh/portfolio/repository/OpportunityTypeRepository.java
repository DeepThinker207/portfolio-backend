package com.deepesh.portfolio.repository;

import com.deepesh.portfolio.entity.OpportunityType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OpportunityTypeRepository extends JpaRepository<OpportunityType, Long> {
    List<OpportunityType> findAllByOrderByDisplayOrderAsc();
    List<OpportunityType> findByVisibleTrueOrderByDisplayOrderAsc();
}
