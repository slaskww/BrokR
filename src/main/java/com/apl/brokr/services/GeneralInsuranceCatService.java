package com.apl.brokr.services;

import com.apl.brokr.model.repositories.GeneralInsuranceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GeneralInsuranceCatService {

    private GeneralInsuranceCategoryRepository generalInsCatRepo;

    @Autowired
    public GeneralInsuranceCatService(GeneralInsuranceCategoryRepository generalInsCatRepo) {
        this.generalInsCatRepo = generalInsCatRepo;
    }
}
