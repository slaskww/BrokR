package com.apl.brokr.model.repositories;

import com.apl.brokr.model.entities.GeneralInsuranceCategory;
import com.apl.brokr.model.entities.InsuranceSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceSubcategoryRepository extends JpaRepository<InsuranceSubcategory, Long> {

    List<InsuranceSubcategory> findAllByGeneralCat_Name(String generalCat);
}
