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
    private UserService userService;

    @Autowired
    public ClientRequestService(ClientRequestRepository clientRequestRepository, GeneralInsuranceCatService generalInsuranceCatService, InsuranceSubcategoryService insuranceSubcategoryService, UserService userService) {
        this.clientRequestRepository = clientRequestRepository;
        this.generalInsuranceCatService = generalInsuranceCatService;
        this.insuranceSubcategoryService = insuranceSubcategoryService;
        this.userService = userService;
    }


    public Map<GeneralInsuranceCategory, Set<InsuranceSubcategory>> getCompleteMapOfInsuranceCategories() {
        List<InsuranceSubcategory> insSubcats = insuranceSubcategoryService.findAll();
        return insSubcats
                .stream()
                .collect(Collectors.groupingBy(o -> o.getGeneralCat(), Collectors.mapping(insuranceSubcategory -> insuranceSubcategory, Collectors.toSet())));

    }

    public void save(RequestDataDto requestDataDto) {
        ClientRequest clientRequest = ClientRequestMapper.toEntity(requestDataDto);
        clientRequestRepository.save(clientRequest);
    }


    public List<RequestDataDto> getAllByUsername(String username) {
        List<ClientRequest> requests = clientRequestRepository.findAllByClient_Username(username);
        return ClientRequestMapper.toDtoList(requests);
    }

    public List<RequestDataDto> getAll(){
        List<ClientRequest> requests = clientRequestRepository.findAll();
        return ClientRequestMapper.toDtoList(requests);
    }

    public RequestDataDto getOneById(Long id) {
        ClientRequest request = clientRequestRepository.findById(id).get();
        return ClientRequestMapper.toDto(request);
    }
}
