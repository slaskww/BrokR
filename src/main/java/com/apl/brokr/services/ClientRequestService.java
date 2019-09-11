package com.apl.brokr.services;

import com.apl.brokr.dto.RequestDataDto;
import com.apl.brokr.dto.mappers.ClientRequestMapper;
import com.apl.brokr.model.entities.ClientRequest;
import com.apl.brokr.model.entities.GeneralInsuranceCategory;
import com.apl.brokr.model.entities.InsuranceSubcategory;
import com.apl.brokr.model.repositories.ClientRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientRequestService {

    private ClientRequestRepository clientRequestRepository;
    private GeneralInsuranceCatService generalInsuranceCatService;
    private InsuranceSubcategoryService insuranceSubcategoryService;

    @Autowired
    public ClientRequestService(ClientRequestRepository clientRR, GeneralInsuranceCatService generalICS, InsuranceSubcategoryService insuranceSS) {
        this.clientRequestRepository = clientRR;
        this.generalInsuranceCatService = generalICS;
        this.insuranceSubcategoryService = insuranceSS;
    }


//    public Map<String, Set<String>> getCompleteMapOfInsuranceCategories() {
//        List<InsuranceSubcategory> insSubcats = insuranceSubcategoryService.findAll();
//        return insSubcats
//                .stream()
//                .collect(Collectors.groupingBy(o -> o.getGeneralCat().getName(), Collectors.mapping(insuranceSubcategory -> insuranceSubcategory.getName(), Collectors.toSet())));
//
//    }

    public Map<GeneralInsuranceCategory, Set<InsuranceSubcategory>> getCompleteMapOfInsuranceCategories() {
        List<InsuranceSubcategory> insSubcats = insuranceSubcategoryService.findAll();
        return insSubcats
                .stream()
                .collect(Collectors.groupingBy(o -> o.getGeneralCat(), Collectors.mapping(insuranceSubcategory -> insuranceSubcategory, Collectors.toSet())));

    }

    public void save(RequestDataDto requestDataDto){
        ClientRequest clientRequest = ClientRequestMapper.toEntity(requestDataDto);
        clientRequestRepository.save(clientRequest);
    }
}
