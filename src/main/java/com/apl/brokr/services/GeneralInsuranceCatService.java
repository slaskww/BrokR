package com.apl.brokr.services;

import com.apl.brokr.model.entities.GeneralInsuranceCategory;
import com.apl.brokr.model.repositories.GeneralInsuranceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GeneralInsuranceCatService {

    private GeneralInsuranceCategoryRepository generalInsCatRepo;

    @Autowired
    public GeneralInsuranceCatService(GeneralInsuranceCategoryRepository generalInsCatRepo) {
        this.generalInsCatRepo = generalInsCatRepo;
    }

    public List<GeneralInsuranceCategory> findAll() {
        return generalInsCatRepo.findAll();
    }
}
