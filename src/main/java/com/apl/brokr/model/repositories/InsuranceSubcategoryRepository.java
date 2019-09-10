package com.apl.brokr.model.repositories;

import com.apl.brokr.model.entities.InsuranceSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceSubcategoryRepository extends JpaRepository<InsuranceSubcategory, Long> {
}
