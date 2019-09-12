package com.apl.brokr.dto.mappers;

import com.apl.brokr.dto.RequestDataDto;
import com.apl.brokr.model.entities.ClientRequest;

import java.util.List;
import java.util.stream.Collectors;


public class ClientRequestMapper {



    public static ClientRequest toEntity(RequestDataDto dataDto){

        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setSubcategories(dataDto.getSubcategories());
        clientRequest.setGeneralInsuranceCategory(dataDto.getSubcategories().get(0).getGeneralCat());
        clientRequest.setClient(dataDto.getClient());

        return clientRequest;
    }


    public static RequestDataDto toDto(ClientRequest clientRequest){

        RequestDataDto dataDto = new RequestDataDto();
        dataDto.setSubcategories(clientRequest.getSubcategories());
        dataDto.setGeneralInsuranceCategory(clientRequest.getGeneralInsuranceCategory());
        dataDto.setClient(clientRequest.getClient());
        dataDto.setId(clientRequest.getId());
        dataDto.setDate(clientRequest.getRequestDate().toLocalDate());

        return dataDto;
    }

    public static List<RequestDataDto> toDtoList(List<ClientRequest> requests){

       return requests.stream().map(clientRequest -> toDto(clientRequest)).collect(Collectors.toList());
    }
}
