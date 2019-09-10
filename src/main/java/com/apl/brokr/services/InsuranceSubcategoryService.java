package com.apl.brokr.services;

import com.apl.brokr.model.entities.InsuranceSubcategory;
import com.apl.brokr.model.repositories.InsuranceSubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InsuranceSubcategoryService {

    private InsuranceSubcategoryRepository insSubcatRepo;

    @Autowired
    public InsuranceSubcategoryService(InsuranceSubcategoryRepository insSubcatRepo) {
        this.insSubcatRepo = insSubcatRepo;
    }

    public List<InsuranceSubcategory> findAll(){

        List<InsuranceSubcategory> list = insSubcatRepo.findAll();
       // list.stream().forEach(insuranceSubcategory -> insuranceSubcategory.getGeneralCat().getName());
       return list;
    }
}
