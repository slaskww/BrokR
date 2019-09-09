package com.apl.brokr.services;

import com.apl.brokr.model.repositories.InsuranceSubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceSubcategoryService {

    private InsuranceSubcategoryRepository insSubcatRepo;

    @Autowired
    public InsuranceSubcategoryService(InsuranceSubcategoryRepository insSubcatRepo) {
        this.insSubcatRepo = insSubcatRepo;
    }
}
